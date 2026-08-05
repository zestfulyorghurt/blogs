import { useState, useEffect, useMemo } from "react";
import { useLanguageStore } from "@/store/languageStore";

const translationsZh = () => import("../locales/zh-CN.json");
const translationsEn = () => import("../locales/en.json");

const translationCache: Record<string, Record<string, unknown>> = {};

/**
 * 懒加载指定语言的翻译字典并写入缓存；若已加载过则直接返回缓存。
 *
 * @param {string} lang - 语言标识（'zh-CN' | 'en'）。
 * @returns {Promise<Record<string, unknown>>} 该语言的翻译字典。
 */
async function loadTranslations(
  lang: string,
): Promise<Record<string, unknown>> {
  if (translationCache[lang]) {
    return translationCache[lang];
  }

  const module =
    lang === "zh-CN" ? await translationsZh() : await translationsEn();
  translationCache[lang] = module.default as Record<string, unknown>;
  return translationCache[lang];
}

/**
 * 应用启动阶段调用，预加载初始语言对应的翻译字典。
 *
 * @param {string} lang - 初始语言标识。
 * @returns {Promise<Record<string, unknown>>} 加载完成的翻译字典。
 */
export function initTranslations(lang: string) {
  return loadTranslations(lang);
}

/**
 * 按点号分隔的键路径（如 "home.heroTitle"）在嵌套字典中逐层取值。
 *
 * @param {Record<string, unknown>} dict - 翻译字典。
 * @param {string} key - 点号分隔的嵌套键。
 * @returns {string | undefined} 命中的字符串，未命中时返回 undefined。
 */
function resolveKey(
  dict: Record<string, unknown>,
  key: string,
): string | undefined {
  const value = key.split(".").reduce<unknown>((acc, part) => {
    if (acc && typeof acc === "object" && !Array.isArray(acc)) {
      return (acc as Record<string, unknown>)[part];
    }
    return undefined;
  }, dict);

  return typeof value === "string" ? value : undefined;
}

/** useTranslation 向组件暴露的能力集合。 */
type TranslationFunctions = {
  t: (key: string, values?: Record<string, string | number>) => string;
  lang: string;
};

/**
 * 翻译 Hook：订阅当前语言，返回取词函数 t() 与当前语言。
 * 当语言切换时自动重载对应翻译字典并触发重渲染。
 *
 * @returns {TranslationFunctions} 包含 t() 与 lang 的对象。
 */
export function useTranslation(): TranslationFunctions {
  const lang = useLanguageStore((state) => state.lang);
  const [, setTick] = useState(0);

  useEffect(() => {
    let cancelled = false;
    loadTranslations(lang).then(() => {
      if (!cancelled) {
        setTick((n) => n + 1);
      }
    });
    return () => {
      cancelled = true;
    };
  }, [lang]);

  const t = useMemo(() => {
    return (key: string, values?: Record<string, string | number>): string => {
      const all = translationCache[lang];
      if (!all) {
        return key;
      }

      let text = resolveKey(all, key) ?? key;

      if (values) {
        Object.entries(values).forEach(([k, v]) => {
          text = text.replace(new RegExp(`{{${k}}}`, "g"), String(v));
        });
      }

      return text;
    };
  }, [lang]);

  return { t, lang };
}
