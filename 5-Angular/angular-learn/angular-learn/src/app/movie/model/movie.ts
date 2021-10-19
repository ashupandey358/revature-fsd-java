import { Genre } from "./genre";
import { MpaaRating } from "./mpaa-rating";

export interface Movie {
  id: number,
  title: string,
  genres: Genre[],
  releaseDate: String,
  mpaaRating: MpaaRating,
  rating: number,
  duration: number,
  budget: number,
  favorite: boolean,
  bookingsOpen: boolean

}