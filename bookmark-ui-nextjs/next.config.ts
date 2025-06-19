import type { NextConfig } from 'next';

const nextConfig: NextConfig = {
  reactStrictMode: true,
  // swcMinify: true, // nextjs 15부터는 선언하지 않아도 된다
  async redirects() {
    return [
      {
        source: '/',
        destination: '/bookmarks',
        permanent: true,
      },
    ];
  },

  env: {
      SERVER_SIDE_API_BASE_URL: process.env.SERVER_SIDE_API_BASE_URL,
      NEXT_PUBLIC_CLIENT_SIDE_API_BASE_URL: process.env.NEXT_PUBLIC_CLIENT_SIDE_API_BASE_URL,
    },
};

export default nextConfig;

