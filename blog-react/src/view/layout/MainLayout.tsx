import {
  cloneElement,
  useState,
  type ReactElement,
  type ReactNode,
} from "react";
import { useTranslation } from "@/hooks/useTranslation";
import "./mainLayout.css";

/** 整体页面框架布局的 props。 */
type MainLayoutProps = {
  header?: ReactNode;
  sidebar?: ReactNode;
  content?: ReactNode;
  footer?: ReactNode;
};

/** 顶部栏的 props。 */
type HeaderProps = {
  title?: string;
  actions?: ReactNode;
  onMenuClick?: () => void;
};

/** 侧边导航的 props。 */
type SidebarProps = {
  items?: string[];
  activeItem?: string;
};

/** 主内容区的 props。 */
type MainContentProps = {
  children?: ReactNode;
};

/** 页脚的 props。 */
type FooterProps = {
  text?: string;
};

/**
 * 顶部栏：展示品牌信息与右侧操作区（含语言切换、菜单按钮等）。
 *
 * @param {HeaderProps} props - 顶部栏配置。
 * @returns {JSX.Element} 渲染后的顶部栏。
 */
export function Header({
  title = "Educom",
  actions,
  onMenuClick,
}: HeaderProps) {
  const { t } = useTranslation();

  return (
    <header className="layout-header">
      <div className="brand-wrap">
        <button
          type="button"
          className="mobile-menu-toggle"
          aria-label={t("common.openMenu")}
          onClick={onMenuClick}
        >
          <span />
          <span />
          <span />
        </button>
        <div className="brand-mark">E</div>
        <div>
          <p className="eyebrow">{t("mainLayout.eyebrow")}</p>
          <h1>{title}</h1>
        </div>
      </div>

      <div className="header-actions">{actions}</div>
    </header>
  );
}

/**
 * 侧边导航：渲染一组导航项，并高亮当前选中项。
 *
 * @param {SidebarProps} props - 侧边栏配置。
 * @returns {JSX.Element} 渲染后的侧边导航。
 */
export function Sidebar({ items, activeItem }: SidebarProps) {
  const { t } = useTranslation();
  const defaultItems = [
    t("mainLayout.dashboard"),
    t("mainLayout.courses"),
    t("mainLayout.schedule"),
    t("mainLayout.reports"),
    t("mainLayout.settings"),
  ];

  return (
    <aside className="sidebar-panel">
      <nav className="sidebar-nav" aria-label="Sidebar navigation">
        {(items ?? defaultItems).map((item) => (
          <button
            key={item}
            type="button"
            className={`nav-item ${activeItem === item ? "active" : ""}`}
          >
            {item}
          </button>
        ))}
      </nav>
    </aside>
  );
}

/**
 * 主内容容器，包裹页面主体内容。
 *
 * @param {MainContentProps} props - 内容区配置。
 * @returns {JSX.Element} 渲染后的主内容区。
 */
export function MainContent({ children }: MainContentProps) {
  return <main className="layout-main">{children}</main>;
}

/**
 * 页脚：展示版权等文案，未传入 text 时回退到多语言默认值。
 *
 * @param {FooterProps} props - 页脚配置。
 * @returns {JSX.Element} 渲染后的页脚。
 */
export function Footer({ text }: FooterProps) {
  const { t } = useTranslation();

  return (
    <footer className="layout-footer">
      <span>{text ?? t("mainLayout.footer")}</span>
    </footer>
  );
}

/**
 * 应用整体框架布局：组合顶部栏、可收起侧边栏、主内容与页脚，
 * 并在移动端管理侧边栏抽屉的开关状态。
 *
 * @param {MainLayoutProps} props - 布局配置。
 * @returns {JSX.Element} 渲染后的应用布局。
 */
export function MainLayout({
  header,
  sidebar,
  content,
  footer,
}: MainLayoutProps) {
  const [mobileOpen, setMobileOpen] = useState(false);

  const toggleMenu = () => setMobileOpen((open) => !open);

  const headerNode = header ? (
    cloneElement(header as ReactElement<HeaderProps>, {
      onMenuClick: toggleMenu,
    })
  ) : (
    <Header onMenuClick={toggleMenu} />
  );

  return (
    <div className="layout-shell">
      {headerNode}

      <div className="layout-body">
        <div
          className={`sidebar-backdrop ${mobileOpen ? "show" : ""}`}
          onClick={() => setMobileOpen(false)}
          aria-hidden="true"
        />

        <div className={`sidebar-drawer ${mobileOpen ? "open" : ""}`}>
          {sidebar || <Sidebar />}
        </div>

        {content || <MainContent> </MainContent>}
      </div>

      {footer || <Footer />}
    </div>
  );
}

export default MainLayout;
