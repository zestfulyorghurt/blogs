import { create } from 'zustand'

type User = {
  id: string
  name: string
  email: string
  avatar?: string
}

type AuthState = {
  user: User | null
  isAuthenticated: boolean
  isLoading: boolean
}

type AuthActions = {
  login: (email: string, password: string) => Promise<void>
  logout: () => void
  setUser: (user: User | null) => void
  setLoading: (loading: boolean) => void
}

export type AuthStore = AuthState & AuthActions

export const useAuthStore = create<AuthStore>((set) => ({
  user: null,
  isAuthenticated: false,
  isLoading: false,

  login: async (email: string) => {
    set({ isLoading: true })
    await new Promise((resolve) => setTimeout(resolve, 500))
    set({
      user: { id: '1', name: 'Demo User', email, avatar: undefined },
      isAuthenticated: true,
      isLoading: false,
    })
  },

  logout: () => {
    set({ user: null, isAuthenticated: false })
  },

  setUser: (user: User | null) => {
    set({ user, isAuthenticated: !!user })
  },

  setLoading: (loading: boolean) => {
    set({ isLoading: loading })
  },
}))
