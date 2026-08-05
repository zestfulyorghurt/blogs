/**
 * 应用入口：挂载 React 根节点，包裹路由、错误边界与 urql Provider，
 * 并在渲染前预加载初始语言对应的翻译字典。
 */
import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { BrowserRouter } from "react-router-dom";
import { ErrorBoundary } from "react-error-boundary";
import { Provider as UrqlProvider } from "urql";
import { urqlClient } from "@/api/client";
import { initTranslations } from "@/hooks/useTranslation";
import { useLanguageStore } from "@/store/languageStore";
import ErrorPage from "@/view/page/ErrorPage";
import "./index.css";
import App from "@/App.tsx";

const lang = useLanguageStore.getState().lang;
initTranslations(lang);

createRoot(document.getElementById("root")!).render(
  <StrictMode>
    <BrowserRouter>
      <ErrorBoundary
        fallbackRender={({ error, resetErrorBoundary }) => (
          <ErrorPage
            error={error as Error}
            resetErrorBoundary={resetErrorBoundary}
          />
        )}
        onError={(error) => console.error("[ErrorBoundary]", error)}
      >
        <UrqlProvider value={urqlClient}>
          <App />
        </UrqlProvider>
      </ErrorBoundary>
    </BrowserRouter>
  </StrictMode>,
);
