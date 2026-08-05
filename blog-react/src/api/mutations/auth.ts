import { gql } from "urql";
import type { LoginInput, LoginPayload } from "@/api/types/common";

/** 登录变更：校验凭据并返回用户信息（id/name/email）与 token。 */
export const LOGIN = gql`
  mutation Login($input: LoginInput!) {
    login(input: $input) {
      user {
        id
        name
        email
      }
      token
    }
  }
`;

/** Login 变更的返回数据结构。 */
export type LoginMutation = {
  login: LoginPayload;
};

/** Login 变更的变量类型。 */
export type LoginVariables = {
  input: LoginInput;
};

/** 登出变更：使当前会话失效。 */
export const LOGOUT = gql`
  mutation Logout {
    logout
  }
`;

/** Logout 变更的返回数据结构。 */
export type LogoutMutation = {
  logout: boolean;
};
