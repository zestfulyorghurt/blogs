import { useLanguageStore } from '@/store/languageStore'

function LanguageSwitcher() {
  const { lang, setLanguage } = useLanguageStore()

  return (
    <div className="language-switcher">
      <button
        type="button"
        className={`lang-btn ${lang === 'zh-CN' ? 'active' : ''}`}
        onClick={() => setLanguage('zh-CN')}
      >
        中文
      </button>
      <button
        type="button"
        className={`lang-btn ${lang === 'en' ? 'active' : ''}`}
        onClick={() => setLanguage('en')}
      >
        EN
      </button>
    </div>
  )
}

export default LanguageSwitcher
