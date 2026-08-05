import { useThemeColorStore, THEME_COLORS } from "@/store/themeStore";
import { useTranslation } from "@/hooks/useTranslation";

/**
 * 主题色切换器：以色块形式展示可选主题色（白 / 黑 / 五彩斑斓的黑等），
 * 点击后写入全局主题色状态，并应用到 <html data-theme-color> 驱动全局换肤。
 *
 * @returns {JSX.Element} 渲染后的主题色切换器。
 */
export default function ThemeColorSwitcher() {
  const { themeColor, setThemeColor } = useThemeColorStore();
  const { t } = useTranslation();

  return (
    <div
      className="theme-color-switcher"
      role="group"
      aria-label={t("theme.title")}
    >
      {THEME_COLORS.map((item) => (
        <button
          key={item.key}
          type="button"
          className={`theme-dot ${themeColor === item.key ? "active" : ""}`}
          style={{ background: item.swatch }}
          title={t(item.labelKey)}
          aria-label={t(item.labelKey)}
          aria-pressed={themeColor === item.key}
          onClick={() => setThemeColor(item.key)}
        />
      ))}
    </div>
  );
}
