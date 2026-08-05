export type Post = {
  id: string
  title: string
  content: string
  excerpt: string
  category: string
  readTime: string
  author: {
    name: string
    avatar?: string
  }
  createdAt: string
  thumbnail?: string
}

export type PostConnection = {
  posts: Post[]
  total: number
  page: number
  pageSize: number
}

export type LoginInput = {
  email: string
  password: string
}

export type LoginPayload = {
  user: {
    id: string
    name: string
    email: string
  }
  token: string
}
