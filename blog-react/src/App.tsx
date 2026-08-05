import "./App.css";
import { Link, Routes, Route } from "react-router-dom";
import {
  Header,
  Sidebar,
  MainContent,
  Footer,
  MainLayout,
} from "@/view/layout/MainLayout";
import SearchPage from "@/view/page/SearchPage";
import LoginPage from "@/view/page/LoginPage";
import RegisterPage from "@/view/page/RegisterPage";
import ErrorPage from "@/view/page/ErrorPage";
import LanguageSwitcher from "@/view/components/LanguageSwitcher";
import { useTranslation } from "@/hooks/useTranslation";

/**
 * 博客首页内容：英雄区、文章列表与侧边个人/统计/订阅卡片。
 * 所有文案通过 useTranslation 的 t() 取词，随语言切换自动刷新。
 *
 * @returns {JSX.Element} 渲染后的首页内容。
 */
function HomePage() {
  const { t } = useTranslation();

  return (
    <div className="blog-home tech-blog">
      <section className="hero-panel tech-hero">
        <div className="hero-copy">
          <p className="hero-kicker">{t("home.heroKicker")}</p>
          <h2>{t("home.heroTitle")}</h2>
          <p>{t("home.heroDescription")}</p>
          <div className="hero-actions">
            <button type="button" className="primary-btn">
              {t("home.latestArticles")}
            </button>
            <button type="button" className="ghost-btn">
              {t("home.aboutAuthor")}
            </button>
          </div>
        </div>
        <div className="hero-highlight">
          <span className="mini-label">{t("home.featured")}</span>
          <h3>{t("home.featuredTitle")}</h3>
          <p>{t("home.featuredDescription")}</p>
        </div>
      </section>

      <div className="content-columns">
        <div className="posts-column">
          <article className="post-card featured-post">
            <div className="post-meta">
              <span>{t("home.frontend")}</span>
              <span>8 min read</span>
            </div>
            <h3>
              React + TypeScript architecture patterns that actually hold up
            </h3>
            <p>
              A practical guide to structuring component systems, shared logic,
              and scalable state boundaries without overengineering.
            </p>
          </article>

          <div className="post-grid">
            <article className="post-card">
              <div className="post-thumb thumb-one" />
              <div className="post-body">
                <div className="post-meta">
                  <span>{t("home.backend")}</span>
                  <span>6 min read</span>
                </div>
                <h4>{t("home.apiDesign")}</h4>
                <p>
                  How to keep contracts clear, versioning predictable, and
                  failures debuggable at scale.
                </p>
              </div>
            </article>

            <article className="post-card">
              <div className="post-thumb thumb-two" />
              <div className="post-body">
                <div className="post-meta">
                  <span>{t("home.performance")}</span>
                  <span>5 min read</span>
                </div>
                <h4>{t("home.profilingReact")}</h4>
                <p>
                  From memoization mistakes to measuring the real bottlenecks in
                  UI interactions.
                </p>
              </div>
            </article>

            <article className="post-card">
              <div className="post-thumb thumb-three" />
              <div className="post-body">
                <div className="post-meta">
                  <span>{t("home.devops")}</span>
                  <span>4 min read</span>
                </div>
                <h4>{t("home.ciPipelines")}</h4>
                <p>
                  Building reliable release flows with fast feedback, safer
                  automation, and better ownership.
                </p>
              </div>
            </article>
          </div>
        </div>

        <aside className="blog-aside">
          <div className="profile-card">
            <div className="avatar">DW</div>
            <h3>{t("home.profileName")}</h3>
            <p>{t("home.profileDesc")}</p>
          </div>

          <div className="stats-card">
            <h4>{t("home.writingStats")}</h4>
            <div className="stat-row">
              <span>{t("home.articles")}</span>
              <strong>84</strong>
            </div>
            <div className="stat-row">
              <span>{t("home.followers")}</span>
              <strong>24.8k</strong>
            </div>
            <div className="stat-row">
              <span>{t("home.openSource")}</span>
              <strong>17</strong>
            </div>
          </div>

          <div className="newsletter-card">
            <h4>{t("home.developerDigest")}</h4>
            <p>{t("home.oneUpdate")}</p>
            <input type="email" placeholder={t("home.emailAddress")} />
            <button type="button">{t("home.joinNow")}</button>
          </div>
        </aside>
      </div>
    </div>
  );
}

/**
 * 应用根组件：配置路由。首页使用 MainLayout 组合各区块，
 * 并提供 /search、/login、/register 等独立页面。
 *
 * @returns {JSX.Element} 渲染后的应用根节点。
 */
function App() {
  const { t } = useTranslation();

  return (
    <Routes>
      <Route
        path="/"
        element={
          <MainLayout
            header={
              <Header
                title="CodeNotes"
                actions={
                  <>
                    <Link to="/search" className="header-link">
                      <button type="button">{t("common.search")}</button>
                    </Link>
                    <Link to="/login" className="header-link">
                      <button type="button">{t("common.newsletter")}</button>
                    </Link>
                    <LanguageSwitcher />
                  </>
                }
              />
            }
            sidebar={
              <Sidebar
                activeItem={t("home.home")}
                items={[
                  t("home.home"),
                  t("home.frontend"),
                  t("home.backend"),
                  t("home.devops"),
                  t("home.architecture"),
                  t("home.about"),
                ]}
              />
            }
            content={
              <MainContent>
                <HomePage />
              </MainContent>
            }
            footer={<Footer text={t("common.footer")} />}
          />
        }
      />
      <Route path="/search" element={<SearchPage />} />
      <Route path="/login" element={<LoginPage />} />
      <Route path="/register" element={<RegisterPage />} />
      <Route path="/error" element={<ErrorPage />} />
    </Routes>
  );
}

export default App;
