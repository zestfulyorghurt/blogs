import { useState, useEffect, useMemo } from 'react'
import { useLanguageStore } from '@/store/languageStore'

const translationsZh = () => import('../locales/zh-CN.json')
const translationsEn = () => import('../locales/en.json')

const translationCache: Record<string, Record<string, unknown>> = {}

async function loadTranslations(lang: string): Promise<Record<string, unknown>> {
  if (translationCache[lang]) {
    return translationCache[lang]
  }

  const module = lang === 'zh-CN' ? await translationsZh() : await translationsEn()
  translationCache[lang] = module.default as Record<string, unknown>
  return translationCache[lang]
}

export function initTranslations(lang: string) {
  return loadTranslations(lang)
}

function resolveKey(dict: Record<string, unknown>, key: string): string | undefined {
  const value = key.split('.').reduce<unknown>((acc, part) => {
    if (acc && typeof acc === 'object' && !Array.isArray(acc)) {
      return (acc as Record<string, unknown>)[part]
    }
    return undefined
  }, dict)

  return typeof value === 'string' ? value : undefined
}

type TranslationFunctions = {
  t: (key: string, values?: Record<string, string | number>) => string
  lang: string
}

export function useTranslation(): TranslationFunctions {
  const lang = useLanguageStore((state) => state.lang)
  const [, setTick] = useState(0)

  useEffect(() => {
    let cancelled = false
    loadTranslations(lang).then(() => {
      if (!cancelled) {
        setTick((n) => n + 1)
      }
    })
    return () => {
      cancelled = true
    }
  }, [lang])

  const t = useMemo(() => {
    return (key: string, values?: Record<string, string | number>): string => {
      const all = translationCache[lang]
      if (!all) {
        return key
      }

      let text = resolveKey(all, key) ?? key

      if (values) {
        Object.entries(values).forEach(([k, v]) => {
          text = text.replace(new RegExp(`{{${k}}}`, 'g'), String(v))
        })
      }

      return text
    }
  }, [lang])

  return { t, lang }
}
