export class Achiv {
  [key: string]: any
  private _id: number;
  private _name: string;
  private _classField: string;
  private _description: string;
  private _checked: boolean;

  constructor(id: number, name: string, clas: string, description: string, checked: boolean) {
    this._id = id;
    this._name = name;
    this._classField = clas;
    this._description = description;
    this._checked = checked;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get classField(): string {
    return this._classField;
  }

  set classField(value: string) {
    this._classField = value;
  }

  get description(): string {
    return this._description;
  }

  set description(value: string) {
    this._description = value;
  }

  get checked(): boolean {
    return this._checked;
  }

  set checked(value: boolean) {
    this._checked = value;
  }


}
