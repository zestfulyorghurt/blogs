/** 单篇文章的数据模型。 */
export type Post = {
  id: string;
  title: string;
  content: string;
  excerpt: string;
  category: string;
  readTime: string;
  author: {
    name: string;
    avatar?: string;
  };
  createdAt: string;
  thumbnail?: string;
};

/** 文章分页连接：文章列表与分页元信息。 */
export type PostConnection = {
  posts: Post[];
  total: number;
  page: number;
  pageSize: number;
};

/** 登录请求的输入参数。 */
export type LoginInput = {
  email: string;
  password: string;
};

/** 登录成功后的返回载荷。 */
export type LoginPayload = {
  user: {
    id: string;
    name: string;
    email: string;
  };
  token: string;
};
