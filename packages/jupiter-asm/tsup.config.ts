import { defineConfig } from 'tsup';

export default defineConfig((opts) => ({
  dts: true,
  clean: true,
  sourcemap: true,
  minify: !opts.watch,
  entry: ['src/index.ts'],
  format: ['cjs', 'esm'],
}));
