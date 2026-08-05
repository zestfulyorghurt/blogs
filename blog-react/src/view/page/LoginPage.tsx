import { useState, type FormEvent } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { useMutation } from 'urql'
import { LOGIN } from '@/api/mutations/auth'
import { useAuthStore } from '@/store/authStore'
import AuthLayout from '@/view/layout/AuthLayout'
import { useTranslation } from '@/hooks/useTranslation'

type LoginForm = {
  email: string
  password: string
}

function LoginPage() {
  const { t } = useTranslation()
  const navigate = useNavigate()
  const setUser = useAuthStore((state) => state.setUser)
  const setLoading = useAuthStore((state) => state.setLoading)
  const [{ fetching }, loginMutation] = useMutation(LOGIN)

  const [form, setForm] = useState<LoginForm>({ email: '', password: '' })
  const [error, setError] = useState<string | null>(null)

  const handleSubmit = async (e: FormEvent) => {
    e.preventDefault()
    setError(null)
    setLoading(true)

    try {
      const result = await loginMutation({ input: { email: form.email, password: form.password } })
      if (result.error) {
        setError(result.error.message)
        return
      }
      if (result.data?.login?.user) {
        setUser(result.data.login.user)
        navigate('/')
      }
    } catch {
      setError(t('auth.loginFailed'))
    } finally {
      setLoading(false)
    }
  }

  return (
    <AuthLayout
      brandTitle={t('auth.login')}
      brandSubtitle={t('auth.loginSubtitle')}
      footerText={t('common.footer')}
    >
      <form onSubmit={handleSubmit}>
        {error && <p className="auth-error">{error}</p>}

        <div className="form-field">
          <label htmlFor="email">{t('auth.email')}</label>
          <input
            id="email"
            type="email"
            required
            placeholder={t('auth.emailPlaceholder')}
            value={form.email}
            onChange={(e) => setForm((f) => ({ ...f, email: e.target.value }))}
          />
        </div>

        <div className="form-field">
          <label htmlFor="password">{t('auth.password')}</label>
          <input
            id="password"
            type="password"
            required
            placeholder={t('auth.passwordPlaceholder')}
            value={form.password}
            onChange={(e) => setForm((f) => ({ ...f, password: e.target.value }))}
          />
        </div>

        <button type="submit" className="auth-submit" disabled={fetching}>
          {fetching ? t('auth.loggingIn') : t('auth.login')}
        </button>

        <p className="auth-switch">
          {t('auth.noAccount')} <Link to="/register">{t('auth.register')}</Link>
        </p>
      </form>
    </AuthLayout>
  )
}

export default LoginPage
