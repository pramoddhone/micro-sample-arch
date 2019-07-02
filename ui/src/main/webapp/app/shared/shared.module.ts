import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { UiSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from './';

@NgModule({
  imports: [UiSharedCommonModule],
  declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
  entryComponents: [JhiLoginModalComponent],
  exports: [UiSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class UiSharedModule {
  static forRoot() {
    return {
      ngModule: UiSharedModule
    };
  }
}
