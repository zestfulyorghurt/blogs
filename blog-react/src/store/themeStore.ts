import { create } from 'zustand'

type Theme = 'light' | 'dark' | 'system'

type ThemeState = {
  theme: Theme
  resolvedTheme: 'light' | 'dark'
}

type ThemeActions = {
  setTheme: (theme: Theme) => void
  toggleTheme: () => void
}

export type ThemeStore = ThemeState & ThemeActions

export const useThemeStore = create<ThemeStore>((set, get) => ({
  theme: 'system',
  resolvedTheme: 'light',

  setTheme: (theme: Theme) => {
    const resolvedTheme = theme === 'system'
      ? (window.matchMedia('(prefers-color-scheme: dark)').matches ? 'dark' : 'light')
      : theme
    set({ theme, resolvedTheme })
  },

  toggleTheme: () => {
    const current = get().theme
    const next = current === 'light' ? 'dark' : current === 'dark' ? 'system' : 'light'
    get().setTheme(next)
  },
}))
