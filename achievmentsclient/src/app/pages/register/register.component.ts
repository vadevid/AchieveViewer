import {Component, Inject} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import axios from "axios";
import {MatSnackBar} from "@angular/material/snack-bar";
import {environment} from "../../../environments/environment";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  login: string = '';
  password: string = '';
  routing: Router;
  route: ActivatedRoute;

  constructor(@Inject(Router) router: Router, @Inject(ActivatedRoute) route: ActivatedRoute, private _snackBar: MatSnackBar) {
    this.routing = router;
    this.route = route;
  }

  async RegisterBtn() {
    if (this.login != '' && this.password != '') {
      await axios.post(environment.serverUrl +"/user/register", {
        "login": this.login,
        "password": this.password
      }).then((response) => {
        console.log(response.data)
        if (response.data == true) {
          this.routing.navigate(['auth']);
        } else {
          this._snackBar.open('Такой пользователь уже существует', '',{
            duration: 3000
          })
        }
      })
    }
  }

}
