export interface Book {
  id: number;
  version: number;
  title: string;
  price: number;
  author_id?: number;
  createdAt: string;
  modifiedAt?: string;
}