import { create } from "zustand";

/** 主题模式：浅色、深色或跟随系统。 */
type Theme = "light" | "dark" | "system";

/** 主题状态的形状。 */
type ThemeState = {
  theme: Theme;
  resolvedTheme: "light" | "dark";
};

/** 主题相关的操作。 */
type ThemeActions = {
  setTheme: (theme: Theme) => void;
  toggleTheme: () => void;
};

/** 主题状态仓库的类型（状态 + 操作）。 */
export type ThemeStore = ThemeState & ThemeActions;

/**
 * 全局主题状态仓库。setTheme 会依据 'system' 解析为实际明暗，
 * toggleTheme 在 light → dark → system 之间循环切换。
 */
export const useThemeStore = create<ThemeStore>((set, get) => ({
  theme: "system",
  resolvedTheme: "light",

  setTheme: (theme: Theme) => {
    const resolvedTheme =
      theme === "system"
        ? window.matchMedia("(prefers-color-scheme: dark)").matches
          ? "dark"
          : "light"
        : theme;
    set({ theme, resolvedTheme });
  },

  toggleTheme: () => {
    const current = get().theme;
    const next =
      current === "light" ? "dark" : current === "dark" ? "system" : "light";
    get().setTheme(next);
  },
}));
