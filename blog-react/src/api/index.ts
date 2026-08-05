/**
 * API 层统一出口：聚合 urql 客户端、GraphQL 查询/变更文档及共享类型，
 * 方便业务代码按桶导入。
 */
export { urqlClient } from "@/api/client";
export { GET_POSTS } from "@/api/queries/posts";
export type { GetPostsQuery, GetPostsVariables } from "@/api/queries/posts";
export { LOGIN, LOGOUT } from "@/api/mutations/auth";
export type {
  LoginMutation,
  LoginVariables,
  LogoutMutation,
} from "@/api/mutations/auth";
export type {
  Post,
  PostConnection,
  LoginInput,
  LoginPayload,
} from "@/api/types/common";
