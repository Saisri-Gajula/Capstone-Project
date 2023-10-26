import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
@Injectable({
  providedIn: 'root'
})
export class SnackbarService {
  constructor(private snackBar: MatSnackBar) {}

  showSuccess(message: string) {
    this.snackBar.open(message, 'OK', {
      duration: 3000, // Duration in milliseconds
      panelClass: 'success-snackbar' // Add your custom CSS class for success messages
    });
  }

  showError(message: string) {
    this.snackBar.open(message, 'OK', {
      duration: 3000, // Duration in milliseconds
      panelClass: 'error-snackbar' // Add your custom CSS class for error messages
    });
  }
}
