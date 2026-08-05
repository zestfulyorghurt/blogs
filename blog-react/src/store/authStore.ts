import { create } from "zustand";

/** 登录用户的数据模型。 */
type User = {
  id: string;
  name: string;
  email: string;
  avatar?: string;
};

/** 认证状态的形状。 */
type AuthState = {
  user: User | null;
  isAuthenticated: boolean;
  isLoading: boolean;
};

/** 认证相关的操作。 */
type AuthActions = {
  login: (email: string, password: string) => Promise<void>;
  logout: () => void;
  setUser: (user: User | null) => void;
  setLoading: (loading: boolean) => void;
};

/** 认证状态仓库的类型（状态 + 操作）。 */
export type AuthStore = AuthState & AuthActions;

/**
 * 全局认证状态仓库。当前为演示实现：login 会模拟网络延迟后写入一个
 * 固定 Demo 用户，真实项目中应替换为实际接口调用。
 */
export const useAuthStore = create<AuthStore>((set) => ({
  user: null,
  isAuthenticated: false,
  isLoading: false,

  login: async (email: string) => {
    set({ isLoading: true });
    await new Promise((resolve) => setTimeout(resolve, 500));
    set({
      user: { id: "1", name: "Demo User", email, avatar: undefined },
      isAuthenticated: true,
      isLoading: false,
    });
  },

  logout: () => {
    set({ user: null, isAuthenticated: false });
  },

  setUser: (user: User | null) => {
    set({ user, isAuthenticated: !!user });
  },

  setLoading: (loading: boolean) => {
    set({ isLoading: loading });
  },
}));
