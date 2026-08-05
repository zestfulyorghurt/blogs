import { useState, type FormEvent } from "react";
import { Link, useNavigate } from "react-router-dom";
import AuthLayout from "@/view/layout/AuthLayout";
import { useTranslation } from "@/hooks/useTranslation";

/** 注册表单的字段状态。 */
type RegisterForm = {
  name: string;
  email: string;
  password: string;
  confirmPassword: string;
};

/**
 * 注册页面：校验两次密码一致且长度达标后跳转登录页。
 * 当前为演示实现，尚未对接真实注册接口。
 *
 * @returns {JSX.Element} 渲染后的注册页面。
 */
function RegisterPage() {
  const { t } = useTranslation();
  const navigate = useNavigate();
  const [form, setForm] = useState<RegisterForm>({
    name: "",
    email: "",
    password: "",
    confirmPassword: "",
  });
  const [error, setError] = useState<string | null>(null);

  const handleSubmit = (e: FormEvent) => {
    e.preventDefault();
    setError(null);

    if (form.password !== form.confirmPassword) {
      setError(t("auth.passwordsDoNotMatch"));
      return;
    }

    if (form.password.length < 6) {
      setError(t("auth.passwordMinLength"));
      return;
    }

    navigate("/login");
  };

  return (
    <AuthLayout
      brandTitle={t("auth.register")}
      brandSubtitle={t("auth.registerSubtitle")}
      footerText={t("common.footer")}
    >
      <form onSubmit={handleSubmit}>
        {error && <p className="auth-error">{error}</p>}

        <div className="form-field">
          <label htmlFor="name">{t("auth.name")}</label>
          <input
            id="name"
            type="text"
            required
            placeholder={t("auth.yourName")}
            value={form.name}
            onChange={(e) => setForm((f) => ({ ...f, name: e.target.value }))}
          />
        </div>

        <div className="form-field">
          <label htmlFor="email">{t("auth.email")}</label>
          <input
            id="email"
            type="email"
            required
            placeholder={t("auth.emailPlaceholder")}
            value={form.email}
            onChange={(e) => setForm((f) => ({ ...f, email: e.target.value }))}
          />
        </div>

        <div className="form-field">
          <label htmlFor="password">{t("auth.password")}</label>
          <input
            id="password"
            type="password"
            required
            placeholder={t("auth.passwordPlaceholder")}
            value={form.password}
            onChange={(e) =>
              setForm((f) => ({ ...f, password: e.target.value }))
            }
          />
        </div>

        <div className="form-field">
          <label htmlFor="confirmPassword">{t("auth.confirmPassword")}</label>
          <input
            id="confirmPassword"
            type="password"
            required
            placeholder={t("auth.passwordPlaceholder")}
            value={form.confirmPassword}
            onChange={(e) =>
              setForm((f) => ({ ...f, confirmPassword: e.target.value }))
            }
          />
        </div>

        <button type="submit" className="auth-submit">
          {t("auth.register")}
        </button>

        <p className="auth-switch">
          {t("auth.haveAccount")} <Link to="/login">{t("auth.login")}</Link>
        </p>
      </form>
    </AuthLayout>
  );
}

export default RegisterPage;
