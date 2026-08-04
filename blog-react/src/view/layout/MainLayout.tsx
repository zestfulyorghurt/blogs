import type { ReactNode } from 'react'
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

export function Header({ title = 'Educom', actions }: HeaderProps) {
  return (
    <header className="layout-header">
      <div className="brand-wrap">
        <div className="brand-mark">E</div>
        <div>
          <p className="eyebrow">Learning platform</p>
          <h1>{title}</h1>
        </div>
      </div>

      <div className="header-actions">{actions}</div>
    </header>
  )
}

export function Sidebar({ items = ['Dashboard', 'Courses', 'Schedule', 'Reports', 'Settings'], activeItem = 'Dashboard' }: SidebarProps) {
  return (
    <aside className="layout-sidebar">
      <nav className="sidebar-nav" aria-label="Sidebar navigation">
        {items.map((item) => (
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

export function Footer({ text = '© 2026 Educom. All rights reserved.' }: FooterProps) {
  return (
    <footer className="layout-footer">
      <span>{text}</span>
    </footer>
  )
}

export function MainLayout({ header, sidebar, content, footer }: MainLayoutProps) {
  return (
    <div className="layout-shell">
      {header || <Header />}

      <div className="layout-body">
        {sidebar || <Sidebar />}
        {content || <MainContent> </MainContent>}
      </div>

      {footer || <Footer />}
    </div>
  )
}

export default MainLayout
