import { createClient, cacheExchange, fetchExchange } from 'urql'

const GRAPHQL_ENDPOINT = import.meta.env.VITE_GRAPHQL_ENDPOINT ?? 'http://localhost:4000/graphql'

export const urqlClient = createClient({
  url: GRAPHQL_ENDPOINT,
  exchanges: [cacheExchange, fetchExchange],
})

export type QueryHook<T> = (options: {
  query: import('graphql').DocumentNode
  variables?: Record<string, unknown>
}) => { data?: T; fetching: boolean; error?: Error }

export type MutationHook<T, V extends Record<string, unknown>> = (
  mutation: import('graphql').DocumentNode,
  options?: {
    variables?: V
    onCompleted?: (data: T) => void
    onError?: (error: Error) => void
  },
) => {
  executeMutation: (vars?: V) => Promise<T | undefined>
  data?: T
  fetching: boolean
  error?: Error
}
