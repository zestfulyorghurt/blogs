import AuthLayout from "@/view/layout/AuthLayout";
import { useTranslation } from "@/hooks/useTranslation";

/**
 * 搜索页面（演示）：复用认证布局展示搜索标题与说明文案。
 *
 * @returns {JSX.Element} 渲染后的搜索页面。
 */
function SearchPage() {
  const { t } = useTranslation();

  return (
    <AuthLayout
      brandTitle={t("common.search")}
      brandSubtitle={t("home.heroDescription")}
      footerText={t("common.footer")}
    >
      <h2>{t("common.search")}</h2>
      <p>{t("home.heroDescription")}</p>
    </AuthLayout>
  );
}

export default SearchPage;
