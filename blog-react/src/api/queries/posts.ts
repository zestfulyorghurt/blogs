import { gql } from "urql";
import type { PostConnection } from "@/api/types/common";

/** 分页获取文章列表，包含每篇文章字段及分页元信息。 */
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
`;

/** GetPosts 查询的返回数据结构。 */
export type GetPostsQuery = {
  posts: PostConnection;
};

/** GetPosts 查询的变量类型。 */
export type GetPostsVariables = {
  page: number;
  pageSize: number;
};
