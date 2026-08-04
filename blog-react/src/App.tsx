import './App.css'
import {
  Header,
  Sidebar,
  MainContent,
  Footer,
  MainLayout,
} from '@/view/layout/MainLayout'

function App() {
  return (
    <MainLayout
      header={
        <Header
          title="CodeNotes"
          actions={
            <>
              <button type="button">Search</button>
              <button type="button">Newsletter</button>
            </>
          }
        />
      }
      sidebar={<Sidebar activeItem="Home" items={['Home', 'Frontend', 'Backend', 'DevOps', 'Architecture', 'About']} />}
      content={
        <MainContent>
          <div className="blog-home tech-blog">
            <section className="hero-panel tech-hero">
              <div className="hero-copy">
                <p className="hero-kicker">Engineering journal</p>
                <h2>Build smarter products.</h2>
                <p>
                  Practical notes on React, TypeScript, backend systems, performance tuning, and the craft of shipping real software.
                </p>
                <div className="hero-actions">
                  <button type="button" className="primary-btn">Latest articles</button>
                  <button type="button" className="ghost-btn">About the author</button>
                </div>
              </div>
              <div className="hero-highlight">
                <span className="mini-label">Featured</span>
                <h3>Designing observable frontends that scale</h3>
                <p>Patterns for resilient UI architecture, metrics, and debugging workflows in growing product teams.</p>
              </div>
            </section>

            <div className="content-columns">
              <div className="posts-column">
                <article className="post-card featured-post">
                  <div className="post-meta">
                    <span>Frontend</span>
                    <span>8 min read</span>
                  </div>
                  <h3>React + TypeScript architecture patterns that actually hold up</h3>
                  <p>
                    A practical guide to structuring component systems, shared logic, and scalable state boundaries without overengineering.
                  </p>
                </article>

                <div className="post-grid">
                  <article className="post-card">
                    <div className="post-thumb thumb-one" />
                    <div className="post-body">
                      <div className="post-meta">
                        <span>Backend</span>
                        <span>6 min read</span>
                      </div>
                      <h4>API design for a multi-service product</h4>
                      <p>How to keep contracts clear, versioning predictable, and failures debuggable at scale.</p>
                    </div>
                  </article>

                  <article className="post-card">
                    <div className="post-thumb thumb-two" />
                    <div className="post-body">
                      <div className="post-meta">
                        <span>Performance</span>
                        <span>5 min read</span>
                      </div>
                      <h4>Profiling and optimizing React renders</h4>
                      <p>From memoization mistakes to measuring the real bottlenecks in UI interactions.</p>
                    </div>
                  </article>

                  <article className="post-card">
                    <div className="post-thumb thumb-three" />
                    <div className="post-body">
                      <div className="post-meta">
                        <span>DevOps</span>
                        <span>4 min read</span>
                      </div>
                      <h4>CI pipelines that catch regressions early</h4>
                      <p>Building reliable release flows with fast feedback, safer automation, and better ownership.</p>
                    </div>
                  </article>
                </div>
              </div>

              <aside className="blog-aside">
                <div className="profile-card">
                  <div className="avatar">DW</div>
                  <h3>Daniel Wu</h3>
                  <p>Frontend engineer, systems thinker, and builder of clean interfaces.</p>
                </div>

                <div className="stats-card">
                  <h4>Writing stats</h4>
                  <div className="stat-row">
                    <span>Articles</span>
                    <strong>84</strong>
                  </div>
                  <div className="stat-row">
                    <span>Followers</span>
                    <strong>24.8k</strong>
                  </div>
                  <div className="stat-row">
                    <span>Open source</span>
                    <strong>17</strong>
                  </div>
                </div>

                <div className="newsletter-card">
                  <h4>Developer digest</h4>
                  <p>One practical update every Friday.</p>
                  <input type="email" placeholder="Email address" />
                  <button type="button">Join now</button>
                </div>
              </aside>
            </div>
          </div>
        </MainContent>
      }
      footer={<Footer text="© 2026 CodeNotes. Engineering notes for curious builders." />}
    />
  )
}

export default App
