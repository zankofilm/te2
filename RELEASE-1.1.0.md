# Madreseyar Teacher Android 1.1.0

نسخه 1.1.0 یک کلاینت رسمی Hybrid برای پنل اصلی مدرسه‌یار است تا همه امکاناتی که Server برای نقش teacher مجاز کرده، بدون ساخت API موازی یا تغییر مخرب Server در Android قابل استفاده باشد.

- آدرس: https://scooljavanrood.ir/app/
- احراز هویت و مجوزها کاملاً توسط Server موجود انجام می‌شود.
- Session/Cookie واقعی Server حفظ می‌شود؛ اپ هیچ ورود ساختگی یا bypass ندارد.
- آپلود فایل از Android WebView پشتیبانی می‌شود.
- دانلود فایل با DownloadManager و Cookie نشست انجام می‌شود.
- لینک‌های خارج از دامنه در مرورگر/اپ مناسب باز می‌شوند.
- Back اندروید با history پنل هماهنگ است.

## ایمنی Server
این نسخه برای فعال شدن به Patch دیتابیس یا جایگزینی server.mjs نیاز ندارد. از APIهای موجود `/api/staff/*`, `/api/state`, `/api/files` و مجوزهای scoped نقش teacher استفاده می‌کند. بنابراین برای این Release هیچ migration، reset یا overwrite داده‌ای انجام نمی‌شود.
