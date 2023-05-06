import {Component, Inject} from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {
  userid: number = 0;
  routing: Router;
  route: ActivatedRoute;
  querySubscription: Subscription;
  constructor(@Inject(Router) router: Router,
              @Inject(ActivatedRoute) route: ActivatedRoute,) {
    this.routing = router;
    this.route = route;
    this.querySubscription = route.queryParams.subscribe((queryParam: any) => {
        this.userid = queryParam['userid']
    })
  }

}
