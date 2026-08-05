import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { BrowserRouter } from "react-router-dom";
import { Provider as UrqlProvider } from "urql";
import { urqlClient } from "@/api/client";
import { initTranslations } from "@/hooks/useTranslation";
import { useLanguageStore } from "@/store/languageStore";
import "./index.css";
import App from "@/App.tsx";

const lang = useLanguageStore.getState().lang;
initTranslations(lang);

/**
 * 应用入口：挂载 React 根节点，包裹路由与 urql Provider，
 * 并在渲染前预加载初始语言对应的翻译字典。
 */
createRoot(document.getElementById("root")!).render(
  <StrictMode>
    <BrowserRouter>
      <UrqlProvider value={urqlClient}>
        <App />
      </UrqlProvider>
    </BrowserRouter>
  </StrictMode>,
);
