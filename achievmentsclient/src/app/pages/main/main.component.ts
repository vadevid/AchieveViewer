import {AfterViewInit, Component, Inject, OnInit, ViewChild} from '@angular/core';
import {map, Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {Achiv} from "../../model/achiv";
import axios from "axios";
import {MatTableDataSource} from "@angular/material/table";
import {MatSort, Sort} from "@angular/material/sort";
import {LiveAnnouncer} from "@angular/cdk/a11y";
import {MatPaginator} from "@angular/material/paginator";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
})
export class MainComponent implements OnInit{
  userid: number = 0;
  routing: Router;
  route: ActivatedRoute;
  querySubscription: Subscription;
  displayedColumns: string[] = ['checked', 'name', 'clas', 'description'];
  achivements:Achiv[] = [];
  achivmentsList = new MatTableDataSource<Achiv>(this.achivements);
  constructor(@Inject(Router) router: Router,
              @Inject(ActivatedRoute) route: ActivatedRoute,
              private _liveAnnouncer: LiveAnnouncer) {
    this.routing = router;
    this.route = route;
    this.querySubscription = route.queryParams.subscribe((queryParam: any) => {
      this.userid = queryParam['userid']
    })
  }

  ngOnInit() {
    this.getData()
  }


  async ChangeSelection(id: number, checked: boolean) {
    if (checked) {
      await axios.post("http://localhost:8080/achiv/uncheck", {
        "userId": this.userid,
        "achivId": id
      })
    } else {
      await axios.post("http://localhost:8080/achiv/check", {
        "userId": this.userid,
        "achivId": id
      })
    }
    this.getData()
  }

  async getData() {
    const response = await axios.post("http://localhost:8080/achiv/getall", {
      id: this.userid
    })
    this.achivements = response.data;
    this.achivmentsList.data = this.achivements
  }
  applyFilter(filterValue: string) {
    this.achivmentsList.filter = filterValue.trim().toLowerCase();
  }

}
