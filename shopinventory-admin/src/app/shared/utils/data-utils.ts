import { Observable, of } from 'rxjs';
import { catchError, take, tap } from 'rxjs/operators';

export class DataUtils {
  static fetchData<T>(request$: Observable<T>): Observable<T> {
    return request$.pipe(
      take(1),
      tap(() => console.log('Fetching data...')),
      catchError(err => {
        console.error('Data fetch failed', err);
        return of([] as unknown as T);
      })
    );
  }
}