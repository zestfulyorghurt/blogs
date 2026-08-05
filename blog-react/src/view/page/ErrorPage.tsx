import { useEffect, type ReactNode } from "react";
import { useNavigate } from "react-router-dom";
import { useTranslation } from "@/hooks/useTranslation";

/** ErrorPage 接收的可选 props。 */
type ErrorPageProps = {
  /** 捕获到的错误对象（作为错误边界兜底时传入）。 */
  error?: Error;
  /** 错误边界提供的重置函数，调用后可重新渲染子组件。 */
  resetErrorBoundary?: () => void;
};

/**
 * 统一错误页：运行时异常经 ErrorBoundary 捕获后作为兜底渲染，
 * 也可通过 /error 路由直接访问。挂载时会把地址改写为 /error 以保持 URL 语义，
 * 并提供“返回首页”与“重试”操作。
 *
 * @param {ErrorPageProps} props - 错误信息与边界重置函数。
 * @returns {JSX.Element} 渲染后的错误页。
 */
export default function ErrorPage({
  error,
  resetErrorBoundary,
}: ErrorPageProps): ReactNode {
  const { t } = useTranslation();
  const navigate = useNavigate();

  // 作为错误边界兜底渲染时，把地址同步为 /error，保证刷新后仍能展示错误页。
  useEffect(() => {
    if (window.location.pathname !== "/error") {
      navigate("/error", {
        replace: true,
        state: { errorMessage: error?.message },
      });
    }
  }, [error, navigate]);

  const handleBackHome = () => {
    navigate("/");
    resetErrorBoundary?.();
  };

  const handleRetry = () => {
    resetErrorBoundary?.();
  };

  return (
    <div className="error-page">
      <div className="error-card">
        <h1>{t("error.title")}</h1>
        <p>{t("error.description")}</p>
        {error?.message && <pre className="error-detail">{error.message}</pre>}
        <div className="error-actions">
          <button
            type="button"
            className="primary-btn"
            onClick={handleBackHome}
          >
            {t("error.backHome")}
          </button>
          {resetErrorBoundary && (
            <button type="button" className="ghost-btn" onClick={handleRetry}>
              {t("error.retry")}
            </button>
          )}
        </div>
      </div>
    </div>
  );
}
