import { create } from "zustand";
import { persist, createJSONStorage } from "zustand/middleware";

/** 可选的主题色标识。 */
export type ThemeColorKey = "white" | "black" | "aurora" | "sunset" | "ocean";

/** 主题色预设：key 用于状态与 data-theme-color，labelKey 取多语言，swatch 为色块预览。 */
export const THEME_COLORS: {
  key: ThemeColorKey;
  labelKey: string;
  swatch: string;
}[] = [
  {
    key: "white",
    labelKey: "theme.white",
    swatch: "linear-gradient(135deg,#2563eb,#7c3aed)",
  },
  {
    key: "black",
    labelKey: "theme.black",
    swatch: "linear-gradient(135deg,#6366f1,#ec4899)",
  },
  {
    key: "aurora",
    labelKey: "theme.aurora",
    swatch: "linear-gradient(90deg,#ff0080,#7928ca,#00d4ff,#2afadf)",
  },
  {
    key: "sunset",
    labelKey: "theme.sunset",
    swatch: "linear-gradient(135deg,#f97316,#ec4899)",
  },
  {
    key: "ocean",
    labelKey: "theme.ocean",
    swatch: "linear-gradient(135deg,#0ea5e9,#14b8a6)",
  },
];

type ThemeColorState = {
  themeColor: ThemeColorKey;
};

type ThemeColorActions = {
  setThemeColor: (key: ThemeColorKey) => void;
};

/** 主题色状态仓库的类型（状态 + 操作）。 */
export type ThemeColorStore = ThemeColorState & ThemeColorActions;

/** 把当前主题色写到 <html data-theme-color>，驱动 CSS 变量切换。 */
function applyThemeColor(key: ThemeColorKey) {
  if (typeof document !== "undefined") {
    document.documentElement.setAttribute("data-theme-color", key);
  }
}

/**
 * 全局主题色状态仓库。选择持久化到 localStorage，
 * 刷新后保留；onRehydrateStorage 在水合后重新应用属性。
 */
export const useThemeColorStore = create<ThemeColorStore>()(
  persist(
    (set) => ({
      themeColor: "white",
      setThemeColor: (key) => {
        applyThemeColor(key);
        set({ themeColor: key });
      },
    }),
    {
      name: "theme-color-storage",
      storage: createJSONStorage(() => localStorage),
      onRehydrateStorage: () => (state) => {
        if (state) {
          applyThemeColor(state.themeColor);
        }
      },
    },
  ),
);

/** 应用启动阶段调用，预应用初始主题色（含持久化后的值）。 */
export function initThemeColor() {
  applyThemeColor(useThemeColorStore.getState().themeColor);
}
