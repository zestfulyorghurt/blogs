import AuthLayout from '@/view/layout/AuthLayout'
import { useTranslation } from '@/hooks/useTranslation'

function SearchPage() {
  const { t } = useTranslation()

  return (
    <AuthLayout
      brandTitle={t('common.search')}
      brandSubtitle={t('home.heroDescription')}
      footerText={t('common.footer')}
    >
      <h2>{t('common.search')}</h2>
      <p>{t('home.heroDescription')}</p>
    </AuthLayout>
  )
}

export default SearchPage
