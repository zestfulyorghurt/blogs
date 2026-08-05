import { useLanguageStore } from "@/store/languageStore";

/**
 * 语言切换器：在「中文 / EN」之间切换，并高亮当前选中的语言。
 * 点击后写入全局语言状态，触发全站文案刷新。
 */
function LanguageSwitcher() {
  const { lang, setLanguage } = useLanguageStore();

  return (
    <div className="language-switcher">
      <button
        type="button"
        className={`lang-btn ${lang === "zh-CN" ? "active" : ""}`}
        onClick={() => setLanguage("zh-CN")}
      >
        中文
      </button>
      <button
        type="button"
        className={`lang-btn ${lang === "en" ? "active" : ""}`}
        onClick={() => setLanguage("en")}
      >
        EN
      </button>
    </div>
  );
}

export default LanguageSwitcher;
