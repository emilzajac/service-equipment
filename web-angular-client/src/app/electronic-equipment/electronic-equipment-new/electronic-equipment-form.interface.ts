import { RapairStatusEnum } from '../rapair-status.enum';
import { CategoryEnum }     from '../category.enum';

export interface ElectronicEquipmentFormInterface {
  name: string;
  identifier: string;
  categoryEnum: CategoryEnum;
  producer: string;
  color: string;
  repairStatusEnum: RapairStatusEnum;
  parameters: ParameterValueForm[];
}

export interface ParameterValueForm {
  parameter: string;
  value: string;
}
