import { create } from "zustand";
import { persist, createJSONStorage } from "zustand/middleware";

/** 应用支持的语言标识。 */
type Language = "zh-CN" | "en";

/** 语言状态的形状。 */
type LanguageState = {
  lang: Language;
};

/** 语言相关的操作。 */
type LanguageActions = {
  setLanguage: (lang: Language) => void;
};

/**
 * 全局语言状态仓库，使用 persist 中间件将用户选择持久化到 localStorage，
 * 刷新后依然保留。
 */
export type LanguageStore = LanguageState & LanguageActions;

/** 全局语言状态 Hook，订阅后可读取/修改当前语言。 */
export const useLanguageStore = create<LanguageStore>()(
  persist(
    (set) => ({
      lang: "zh-CN",
      setLanguage: (lang) => set({ lang }),
    }),
    {
      name: "language-storage",
      storage: createJSONStorage(() => localStorage),
    },
  ),
);
