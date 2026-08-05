import { gql } from 'urql'
import type { PostConnection } from '@/api/types/common'

export const GET_POSTS = gql`
  query GetPosts($page: Int!, $pageSize: Int!) {
    posts(page: $page, pageSize: $pageSize) {
      posts {
        id
        title
        excerpt
        category
        readTime
        author {
          name
          avatar
        }
        createdAt
        thumbnail
      }
      total
      page
      pageSize
    }
  }
`

export type GetPostsQuery = {
  posts: PostConnection
}

export type GetPostsVariables = {
  page: number
  pageSize: number
}
