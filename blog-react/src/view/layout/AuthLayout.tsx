import { type ReactNode } from 'react'
import { useTranslation } from '@/hooks/useTranslation'
import './authLayout.css'

type AuthLayoutProps = {
  brandMark?: ReactNode
  brandTitle?: string
  brandSubtitle?: string
  children?: ReactNode
  footerText?: string
}

export function AuthLayout({
  brandMark,
  brandTitle,
  brandSubtitle,
  children,
  footerText,
}: AuthLayoutProps) {
  const { t } = useTranslation()

  return (
    <div className="auth-shell">
      <div className="auth-card">
        <div className="auth-brand">
          {brandMark ?? <div className="auth-brand-mark">E</div>}
          <div className="auth-brand-text">
            <p className="auth-eyebrow">{brandSubtitle ?? t('mainLayout.eyebrow')}</p>
            <h1>{brandTitle ?? t('common.brand')}</h1>
          </div>
        </div>

        <div className="auth-body">{children}</div>
      </div>

      <footer className="auth-footer">
        <span>{footerText ?? t('mainLayout.footer')}</span>
      </footer>
    </div>
  )
}

export default AuthLayout
