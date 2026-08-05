import { createClient, cacheExchange, fetchExchange } from "urql";

/** GraphQL 服务端点，优先读取环境变量，缺失时回退到本地默认地址。 */
const GRAPHQL_ENDPOINT =
  import.meta.env.VITE_GRAPHQL_ENDPOINT ?? "http://localhost:4000/graphql";

/** 全局共享的 urql 客户端实例，供所有查询与变更复用。 */
export const urqlClient = createClient({
  url: GRAPHQL_ENDPOINT,
  exchanges: [cacheExchange, fetchExchange],
});

/** 通用查询 Hook 的返回结构（泛型 T 表示查询数据类型）。 */
export type QueryHook<T> = (options: {
  query: import("graphql").DocumentNode;
  variables?: Record<string, unknown>;
}) => { data?: T; fetching: boolean; error?: Error };

/** 通用变更 Hook 的返回结构（T 为返回类型，V 为变量类型）。 */
export type MutationHook<T, V extends Record<string, unknown>> = (
  mutation: import("graphql").DocumentNode,
  options?: {
    variables?: V;
    onCompleted?: (data: T) => void;
    onError?: (error: Error) => void;
  },
) => {
  executeMutation: (vars?: V) => Promise<T | undefined>;
  data?: T;
  fetching: boolean;
  error?: Error;
};
