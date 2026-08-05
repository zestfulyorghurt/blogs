import { create } from "zustand";

/** 侧边栏状态的形状。 */
type SidebarState = {
  isOpen: boolean;
  activeItem: string;
  items: string[];
};

/** 侧边栏相关的操作。 */
type SidebarActions = {
  toggleSidebar: () => void;
  setActiveItem: (item: string) => void;
  setItems: (items: string[]) => void;
};

/** 侧边栏状态仓库的类型（状态 + 操作）。 */
export type SidebarStore = SidebarState & SidebarActions;

/** 全局侧边栏状态 Hook，控制展开/收起与选中项。 */
export const useSidebarStore = create<SidebarStore>((set) => ({
  isOpen: true,
  activeItem: "Home",
  items: ["Dashboard", "Courses", "Schedule", "Reports", "Settings"],
  toggleSidebar: () => set((state) => ({ isOpen: !state.isOpen })),
  setActiveItem: (item: string) => set({ activeItem: item }),
  setItems: (items: string[]) => set({ items }),
}));
