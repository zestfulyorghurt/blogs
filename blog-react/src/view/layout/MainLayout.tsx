import { cloneElement, useState, type ReactElement, type ReactNode } from 'react'
import { useTranslation } from '@/hooks/useTranslation'
import './mainLayout.css'

type MainLayoutProps = {
  header?: ReactNode
  sidebar?: ReactNode
  content?: ReactNode
  footer?: ReactNode
}

type HeaderProps = {
  title?: string
  actions?: ReactNode
  onMenuClick?: () => void
}

type SidebarProps = {
  items?: string[]
  activeItem?: string
}

type MainContentProps = {
  children?: ReactNode
}

type FooterProps = {
  text?: string
}

export function Header({ title = 'Educom', actions, onMenuClick }: HeaderProps) {
  const { t } = useTranslation()

  return (
    <header className="layout-header">
      <div className="brand-wrap">
        <button
          type="button"
          className="mobile-menu-toggle"
          aria-label={t('common.openMenu')}
          onClick={onMenuClick}
        >
          <span />
          <span />
          <span />
        </button>
        <div className="brand-mark">E</div>
        <div>
          <p className="eyebrow">{t('mainLayout.eyebrow')}</p>
          <h1>{title}</h1>
        </div>
      </div>

      <div className="header-actions">{actions}</div>
    </header>
  )
}

export function Sidebar({ items, activeItem }: SidebarProps) {
  const { t } = useTranslation()
  const defaultItems = [
    t('mainLayout.dashboard'),
    t('mainLayout.courses'),
    t('mainLayout.schedule'),
    t('mainLayout.reports'),
    t('mainLayout.settings'),
  ]

  return (
    <aside className="sidebar-panel">
      <nav className="sidebar-nav" aria-label="Sidebar navigation">
        {(items ?? defaultItems).map((item) => (
          <button
            key={item}
            type="button"
            className={`nav-item ${activeItem === item ? 'active' : ''}`}
          >
            {item}
          </button>
        ))}
      </nav>
    </aside>
  )
}

export function MainContent({ children }: MainContentProps) {
  return <main className="layout-main">{children}</main>
}

export function Footer({ text }: FooterProps) {
  const { t } = useTranslation()

  return (
    <footer className="layout-footer">
      <span>{text ?? t('mainLayout.footer')}</span>
    </footer>
  )
}

export function MainLayout({ header, sidebar, content, footer }: MainLayoutProps) {
  const [mobileOpen, setMobileOpen] = useState(false)

  const toggleMenu = () => setMobileOpen((open) => !open)

  const headerNode = header
    ? cloneElement(header as ReactElement<HeaderProps>, {
        onMenuClick: toggleMenu,
      })
    : <Header onMenuClick={toggleMenu} />

  return (
    <div className="layout-shell">
      {headerNode}

      <div className="layout-body">
        <div
          className={`sidebar-backdrop ${mobileOpen ? 'show' : ''}`}
          onClick={() => setMobileOpen(false)}
          aria-hidden="true"
        />

        <div className={`sidebar-drawer ${mobileOpen ? 'open' : ''}`}>
          {sidebar || <Sidebar />}
        </div>

        {content || <MainContent> </MainContent>}
      </div>

      {footer || <Footer />}
    </div>
  )
}

export default MainLayout
