import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Periferico } from './periferico';

describe('Periferico', () => {
  let component: Periferico;
  let fixture: ComponentFixture<Periferico>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Periferico],
    }).compileComponents();

    fixture = TestBed.createComponent(Periferico);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
