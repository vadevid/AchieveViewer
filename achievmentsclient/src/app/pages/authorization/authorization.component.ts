import {Component, EventEmitter, Inject} from '@angular/core';
import axios from 'axios'
import {ActivatedRoute, Router} from "@angular/router";
import {environment} from "../../../environments/environment";

@Component({
  selector: 'app-authorization',
  templateUrl: './authorization.component.html',
  styleUrls: ['./authorization.component.css']
})
export class AuthorizationComponent {
  userid: number = 0;
  login: string = '';
  password: string = '';
  routing: Router;
  route: ActivatedRoute;

  constructor(@Inject(Router) router: Router, @Inject(ActivatedRoute) route: ActivatedRoute) {
    this.routing = router;
    this.route = route;
  }


  async LoginBtn() {
    if (this.login != '' && this.password != '') {
      await axios.post(environment.serverUrl +"/user/login", {
        "login": this.login,
        "password": this.password
      }).then((response) => {
        this.userid = Number(response.data.id)
        this.routing.navigate(['main'], {
          queryParams: {
            'userid': this.userid
          }
        })
      })
    }
  }
}
