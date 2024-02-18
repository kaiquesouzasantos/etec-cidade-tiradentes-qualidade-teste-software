import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';
import * as env from 'dotenv';
import { ValidationPipe } from '@nestjs/common';
env.config();

async function bootstrap() {
  const app = await NestFactory.create(AppModule, { cors: true });
  app.useGlobalPipes(
    new ValidationPipe({
      whitelist: true,
      forbidNonWhitelisted: true,
    }),
  );

  await app.listen(process.env.PORT);
}
bootstrap();
