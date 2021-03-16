export class Aspiration {
  name: string;
  description: string;
  category: string;
  bonus: string;
  dlcName: string;
  isChild: boolean;
  isTeenager: boolean;

  constructor(name?, description?, category?, bonus?, dlcName?, isChild?, isTeenager?) {
    this.name = name;
    this.description = description;
    this.category = category;
    this.bonus = bonus;
    this.dlcName = dlcName;
    this.isChild = isChild;
    this.isTeenager = isTeenager;
  }
}
