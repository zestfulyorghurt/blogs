import { type ReactNode } from "react";
import { useTranslation } from "@/hooks/useTranslation";
import "./authLayout.css";

/** AuthLayout 接收的 props。 */
type AuthLayoutProps = {
  brandMark?: ReactNode;
  brandTitle?: string;
  brandSubtitle?: string;
  children?: ReactNode;
  footerText?: string;
};

/**
 * 认证类页面（登录 / 注册 / 搜索）的通用外壳布局。
 * 提供品牌区、内容容器与页脚；未显式传入的文案会回退到多语言默认值。
 *
 * @param {AuthLayoutProps} props - 布局配置。
 * @returns {JSX.Element} 渲染后的认证布局。
 */
export function AuthLayout({
  brandMark,
  brandTitle,
  brandSubtitle,
  children,
  footerText,
}: AuthLayoutProps) {
  const { t } = useTranslation();

  return (
    <div className="auth-shell">
      <div className="auth-card">
        <div className="auth-brand">
          {brandMark ?? <div className="auth-brand-mark">E</div>}
          <div className="auth-brand-text">
            <p className="auth-eyebrow">
              {brandSubtitle ?? t("mainLayout.eyebrow")}
            </p>
            <h1>{brandTitle ?? t("common.brand")}</h1>
          </div>
        </div>

        <div className="auth-body">{children}</div>
      </div>

      <footer className="auth-footer">
        <span>{footerText ?? t("mainLayout.footer")}</span>
      </footer>
    </div>
  );
}

export default AuthLayout;
