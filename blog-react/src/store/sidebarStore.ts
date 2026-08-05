import { create } from 'zustand'

type SidebarState = {
  isOpen: boolean
  activeItem: string
  items: string[]
}

type SidebarActions = {
  toggleSidebar: () => void
  setActiveItem: (item: string) => void
  setItems: (items: string[]) => void
}

export type SidebarStore = SidebarState & SidebarActions

export const useSidebarStore = create<SidebarStore>((set) => ({
  isOpen: true,
  activeItem: 'Home',
  items: ['Dashboard', 'Courses', 'Schedule', 'Reports', 'Settings'],

  toggleSidebar: () => set((state) => ({ isOpen: !state.isOpen })),

  setActiveItem: (item: string) => set({ activeItem: item }),

  setItems: (items: string[]) => set({ items }),
}))
