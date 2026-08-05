import { gql } from 'urql'
import type { LoginInput, LoginPayload } from '@/api/types/common'

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
`

export type LoginMutation = {
  login: LoginPayload
}

export type LoginVariables = {
  input: LoginInput
}

export const LOGOUT = gql`
  mutation Logout {
    logout
  }
`

export type LogoutMutation = {
  logout: boolean
}
