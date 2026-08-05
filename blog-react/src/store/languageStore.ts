import { create } from 'zustand'
import { persist, createJSONStorage } from 'zustand/middleware'

type Language = 'zh-CN' | 'en'

type LanguageState = {
  lang: Language
}

type LanguageActions = {
  setLanguage: (lang: Language) => void
}

export type LanguageStore = LanguageState & LanguageActions

export const useLanguageStore = create<LanguageStore>()(
  persist(
    (set) => ({
      lang: 'zh-CN',
      setLanguage: (lang) => set({ lang }),
    }),
    {
      name: 'language-storage',
      storage: createJSONStorage(() => localStorage),
    },
  ),
)
