package inmorate.xfuzzy;

//++++++++++++++++++++++++++++++++++++++++++++++++++++++//
//     Fuzzy Inference Engine valoracionInmuebles      //
//++++++++++++++++++++++++++++++++++++++++++++++++++++++//

public class valoracionInmuebles implements FuzzyInferenceEngine {

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //      Membership function of an input variable       //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private abstract class InnerMembershipFunction {
  double min, max, step;
  abstract double param(int i);
  double center() { return 0; }
  double basis() { return 0; }
  abstract double isEqual(double x);

  double isSmallerOrEqual(double x) {
   double degree=0, mu;
   for(double y=max; y>=x ; y-=step) if((mu = isEqual(y))>degree) degree=mu;
   return degree;
  }

  double isGreaterOrEqual(double x) {
   double degree=0, mu;
   for(double y=min; y<=x ; y+=step) if((mu = isEqual(y))>degree) degree=mu;
   return degree;
  }

  double isEqual(MembershipFunction mf) {
   if(mf instanceof FuzzySingleton)
    { return isEqual( ((FuzzySingleton) mf).getValue()); }
   if((mf instanceof OutputMembershipFunction) &&
      ((OutputMembershipFunction) mf).isDiscrete() ) {
    double[][] val = ((OutputMembershipFunction) mf).getDiscreteValues();
    double deg = 0;
    for(int i=0; i<val.length; i++){
     double mu = isEqual(val[i][0]);
     double minmu = (mu<val[i][1] ? mu : val[i][1]);
     if( deg<minmu ) deg = minmu;
    }
    return deg;
   }
   double mu1,mu2,minmu,degree=0;
   for(double x=min; x<=max; x+=step){
    mu1 = mf.compute(x);
    mu2 = isEqual(x);
    minmu = (mu1<mu2 ? mu1 : mu2);
    if( degree<minmu ) degree = minmu;
   }
   return degree;
  }

  double isGreaterOrEqual(MembershipFunction mf) {
   if(mf instanceof FuzzySingleton)
    { return isGreaterOrEqual( ((FuzzySingleton) mf).getValue()); }
   if((mf instanceof OutputMembershipFunction) &&
      ((OutputMembershipFunction) mf).isDiscrete() ) {
    double[][] val = ((OutputMembershipFunction) mf).getDiscreteValues();
    double deg = 0;
    for(int i=0; i<val.length; i++){
     double mu = isGreaterOrEqual(val[i][0]);
     double minmu = (mu<val[i][1] ? mu : val[i][1]);
     if( deg<minmu ) deg = minmu;
    }
    return deg;
   }
   double mu1,mu2,minmu,degree=0,greq=0;
   for(double x=min; x<=max; x+=step){
    mu1 = mf.compute(x);
    mu2 = isEqual(x);
    if( mu2>greq ) greq = mu2;
    if( mu1<greq ) minmu = mu1; else minmu = greq;
    if( degree<minmu ) degree = minmu;
   }
   return degree;
  }

  double isSmallerOrEqual(MembershipFunction mf) {
   if(mf instanceof FuzzySingleton)
    { return isSmallerOrEqual( ((FuzzySingleton) mf).getValue()); }
   if((mf instanceof OutputMembershipFunction) &&
      ((OutputMembershipFunction) mf).isDiscrete() ) {
    double[][] val = ((OutputMembershipFunction) mf).getDiscreteValues();
    double deg = 0;
    for(int i=0; i<val.length; i++){
     double mu = isSmallerOrEqual(val[i][0]);
     double minmu = (mu<val[i][1] ? mu : val[i][1]);
     if( deg<minmu ) deg = minmu;
    }
    return deg;
   }
   double mu1,mu2,minmu,degree=0,smeq=0;
   for(double x=max; x>=min; x-=step){
    mu1 = mf.compute(x);
    mu2 = isEqual(x);
    if( mu2>smeq ) smeq = mu2;
    if( mu1<smeq ) minmu = mu1; else minmu = smeq;
    if( degree<minmu ) degree = minmu;
   }
   return degree;
  }

  double isGreater(MembershipFunction mf, InnerOperatorset op) {
   if(mf instanceof FuzzySingleton)
    { return op.not(isSmallerOrEqual( ((FuzzySingleton) mf).getValue())); }
   if((mf instanceof OutputMembershipFunction) &&
      ((OutputMembershipFunction) mf).isDiscrete() ) {
    double[][] val = ((OutputMembershipFunction) mf).getDiscreteValues();
    double deg = 0;
    for(int i=0; i<val.length; i++){
     double mu = op.not(isSmallerOrEqual(val[i][0]));
     double minmu = (mu<val[i][1] ? mu : val[i][1]);
     if( deg<minmu ) deg = minmu;
    }
    return deg;
   }
   double mu1,mu2,minmu,gr,degree=0,smeq=0;
   for(double x=max; x>=min; x-=step){
    mu1 = mf.compute(x);
    mu2 = isEqual(x);
    if( mu2>smeq ) smeq = mu2;
    gr = op.not(smeq);
    minmu = ( mu1<gr ? mu1 : gr);
    if( degree<minmu ) degree = minmu;
   }
   return degree;
  }

  double isSmaller(MembershipFunction mf, InnerOperatorset op) {
   if(mf instanceof FuzzySingleton)
    { return op.not(isGreaterOrEqual( ((FuzzySingleton) mf).getValue())); }
   if((mf instanceof OutputMembershipFunction) &&
      ((OutputMembershipFunction) mf).isDiscrete() ) {
    double[][] val = ((OutputMembershipFunction) mf).getDiscreteValues();
    double deg = 0;
    for(int i=0; i<val.length; i++){
     double mu = op.not(isGreaterOrEqual(val[i][0]));
     double minmu = (mu<val[i][1] ? mu : val[i][1]);
     if( deg<minmu ) deg = minmu;
    }
    return deg;
   }
   double mu1,mu2,minmu,sm,degree=0,greq=0;
   for(double x=min; x<=max; x+=step){
    mu1 = mf.compute(x);
    mu2 = isEqual(x);
    if( mu2>greq ) greq = mu2;
    sm = op.not(greq);
    minmu = ( mu1<sm ? mu1 : sm);
    if( degree<minmu ) degree = minmu;
   }
   return degree;
  }

  double isNotEqual(MembershipFunction mf, InnerOperatorset op) {
   if(mf instanceof FuzzySingleton)
    { return op.not(isEqual( ((FuzzySingleton) mf).getValue())); }
   if((mf instanceof OutputMembershipFunction) &&
      ((OutputMembershipFunction) mf).isDiscrete() ) {
    double[][] val = ((OutputMembershipFunction) mf).getDiscreteValues();
    double deg = 0;
    for(int i=0; i<val.length; i++){
     double mu = op.not(isEqual(val[i][0]));
     double minmu = (mu<val[i][1] ? mu : val[i][1]);
     if( deg<minmu ) deg = minmu;
    }
    return deg;
   }
   double mu1,mu2,minmu,degree=0;
   for(double x=min; x<=max; x+=step){
    mu1 = mf.compute(x);
    mu2 = op.not(isEqual(x));
    minmu = (mu1<mu2 ? mu1 : mu2);
    if( degree<minmu ) degree = minmu;
   }
   return degree;
  }

  double isApproxEqual(MembershipFunction mf, InnerOperatorset op) {
   if(mf instanceof FuzzySingleton)
    { return op.moreorless(isEqual( ((FuzzySingleton) mf).getValue())); }
   if((mf instanceof OutputMembershipFunction) &&
      ((OutputMembershipFunction) mf).isDiscrete() ) {
    double[][] val = ((OutputMembershipFunction) mf).getDiscreteValues();
    double deg = 0;
    for(int i=0; i<val.length; i++){
     double mu = op.moreorless(isEqual(val[i][0]));
     double minmu = (mu<val[i][1] ? mu : val[i][1]);
     if( deg<minmu ) deg = minmu;
    }
    return deg;
   }
   double mu1,mu2,minmu,degree=0;
   for(double x=min; x<=max; x+=step){
    mu1 = mf.compute(x);
    mu2 = op.moreorless(isEqual(x));
    minmu = (mu1<mu2 ? mu1 : mu2);
    if( degree<minmu ) degree = minmu;
   }
   return degree;
  }

  double isVeryEqual(MembershipFunction mf, InnerOperatorset op) {
   if(mf instanceof FuzzySingleton)
    { return op.very(isEqual( ((FuzzySingleton) mf).getValue())); }
   if((mf instanceof OutputMembershipFunction) &&
      ((OutputMembershipFunction) mf).isDiscrete() ) {
    double[][] val = ((OutputMembershipFunction) mf).getDiscreteValues();
    double deg = 0;
    for(int i=0; i<val.length; i++){
     double mu = op.very(isEqual(val[i][0]));
     double minmu = (mu<val[i][1] ? mu : val[i][1]);
     if( deg<minmu ) deg = minmu;
    }
    return deg;
   }
   double mu1,mu2,minmu,degree=0;
   for(double x=min; x<=max; x+=step){
    mu1 = mf.compute(x);
    mu2 = op.very(isEqual(x));
    minmu = (mu1<mu2 ? mu1 : mu2);
    if( degree<minmu ) degree = minmu;
   }
   return degree;
  }

  double isSlightlyEqual(MembershipFunction mf, InnerOperatorset op) {
   if(mf instanceof FuzzySingleton)
    { return op.slightly(isEqual( ((FuzzySingleton) mf).getValue())); }
   if((mf instanceof OutputMembershipFunction) &&
      ((OutputMembershipFunction) mf).isDiscrete() ) {
    double[][] val = ((OutputMembershipFunction) mf).getDiscreteValues();
    double deg = 0;
    for(int i=0; i<val.length; i++){
     double mu = op.slightly(isEqual(val[i][0]));
     double minmu = (mu<val[i][1] ? mu : val[i][1]);
     if( deg<minmu ) deg = minmu;
    }
    return deg;
   }
   double mu1,mu2,minmu,degree=0;
   for(double x=min; x<=max; x+=step){
    mu1 = mf.compute(x);
    mu2 = op.slightly(isEqual(x));
    minmu = (mu1<mu2 ? mu1 : mu2);
    if( degree<minmu ) degree = minmu;
   }
   return degree;
  }
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //          Abstract class of an operator set          //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private abstract class InnerOperatorset {
  abstract double and(double a, double b);
  abstract double or(double a, double b);
  abstract double also(double a, double b);
  abstract double imp(double a, double b);
  abstract double not(double a);
  abstract double very(double a);
  abstract double moreorless(double a);
  abstract double slightly(double a);
  abstract double defuz(OutputMembershipFunction mf);
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //      Class for the conclusion of a fuzzy rule       //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private class InnerConclusion {
  private double degree;
  private InnerMembershipFunction mf;
  private InnerOperatorset op;

  InnerConclusion(double degree, InnerMembershipFunction mf, InnerOperatorset op) {
   this.op = op;
   this.degree = degree;
   this.mf = mf;
  }

  public double degree() { return degree; }
  public double compute(double x) { return op.imp(degree,mf.isEqual(x)); }
  public double center() { return mf.center(); }
  public double basis() { return mf.basis(); }
  public double param(int i) { return mf.param(i); }
  public double min() { return mf.min; }
  public double max() { return mf.max; }
  public double step() { return mf.step; }
  public boolean isSingleton() { 
   return mf.getClass().getName().endsWith("MF_xfl_singleton");
  }
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //      Membership function of an output variable      //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private class OutputMembershipFunction implements MembershipFunction {
  public InnerConclusion[] conc;
  public double[] input;
  private InnerOperatorset op;

  OutputMembershipFunction() {
   this.conc = new InnerConclusion[0];
  }

  public void set(int size, InnerOperatorset op, double[] input) {
   this.input = input;
   this.op = op;
   this.conc = new InnerConclusion[size];
  }

  public void set(int pos, double dg, InnerMembershipFunction imf) {
   this.conc[pos] = new InnerConclusion(dg,imf,op);
  }

  public double compute(double x) {
   double dom = conc[0].compute(x);
   for(int i=1; i<conc.length; i++) dom = op.also(dom,conc[i].compute(x));
   return dom;
  }

  public double defuzzify() {
   return op.defuz(this);
  }

  public double min() {
   return conc[0].min();
  }

  public double max() {
   return conc[0].max();
  }

  public double step() {
   return conc[0].step();
  }

  public boolean isDiscrete() {
   for(int i=0; i<conc.length; i++) if(!conc[i].isSingleton()) return false;
   return true;
  }
 
  public double[][] getDiscreteValues() {
   double[][] value = new double[conc.length][2];
   for(int i=0; i<conc.length; i++) {
    value[i][0] = conc[i].param(0);
    value[i][1] = conc[i].degree();
   }
   return value;
  }

 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //      Membership function MF_xfl_singleton      //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

  private class MF_xfl_singleton extends InnerMembershipFunction {
   double a;

   MF_xfl_singleton( double min, double max, double step, double param[]){
    super.min = min;
    super.max = max;
    super.step = step;
    this.a = param[0];
   }
   double param(int _i) {
    switch(_i) {
     case 0: return a;
     default: return 0;
    }
   }
   double isEqual(double x) {
    return (x==a? 1 : 0); 
   }
   double isGreaterOrEqual(double x) {
    return (x>=a? 1 : 0); 
   }
   double isSmallerOrEqual(double x) {
    return (x<=a? 1 : 0); 
   }
   double center() {
    return a; 
   }
  }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //      Membership function MF_xfl_bell      //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

  private class MF_xfl_bell extends InnerMembershipFunction {
   double a;
   double b;

   MF_xfl_bell( double min, double max, double step, double param[]){
    super.min = min;
    super.max = max;
    super.step = step;
    this.a = param[0];
    this.b = param[1];
   }
   double param(int _i) {
    switch(_i) {
     case 0: return a;
     case 1: return b;
     default: return 0;
    }
   }
   double isEqual(double x) {
    return Math.exp( -(a-x)*(a-x)/(b*b) ); 
   }
   double isGreaterOrEqual(double x) {
    if(x>a) return 1; return Math.exp( - (x-a)*(x-a)/(b*b) ); 
   }
   double isSmallerOrEqual(double x) {
    if(x<a) return 1; return Math.exp( - (x-a)*(x-a)/(b*b) ); 
   }
   double center() {
    return a; 
   }
   double basis() {
    return b; 
   }
  }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //     Operator set OP__default_      //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private class OP__default_ extends InnerOperatorset {
  double and(double a, double b) {
    return (a<b? a : b); 
  }
  double or(double a, double b) {
    return (a>b? a : b); 
  }
  double also(double a, double b) {
    return (a>b? a : b); 
  }
  double imp(double a, double b) {
    return (a<b? a : b); 
  }
  double not(double a) {
    return 1-a; 
  }
  double very(double a) {
   double w = 2.0;
    return Math.pow(a,w); 
  }
  double moreorless(double a) {
   double w = 0.5;
    return Math.pow(a,w); 
  }
  double slightly(double a) {
    return 4*a*(1-a); 
  }
 double defuz(OutputMembershipFunction mf) {
   double min = mf.min();
   double max = mf.max();
   double step = mf.step();
  double num=0, denom=0;
  for(double x=min; x<=max; x+=step) {
   double m = mf.compute(x);
   num += x*m;
   denom += m;
  }
  if(denom==0) return (min+max)/2;
  return num/denom;
  }
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Type TP_TipoInmueble  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private class TP_TipoInmueble {
  private double min = 1.0;
  private double max = 4.0;
  private double step = 0.75;
  double _p_Piso[] = { 1.0 };
  double _p_Adosado[] = { 2.0 };
  double _p_Pareado[] = { 3.0 };
  double _p_Independiente[] = { 4.0 };
  MF_xfl_singleton Piso = new MF_xfl_singleton(min,max,step,_p_Piso);
  MF_xfl_singleton Adosado = new MF_xfl_singleton(min,max,step,_p_Adosado);
  MF_xfl_singleton Pareado = new MF_xfl_singleton(min,max,step,_p_Pareado);
  MF_xfl_singleton Independiente = new MF_xfl_singleton(min,max,step,_p_Independiente);
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Type TP_Numero  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private class TP_Numero {
  private double min = 1.0;
  private double max = 10.0;
  private double step = 0.9;
  double _p_uno[] = { 1.0 };
  double _p_dos[] = { 2.0 };
  double _p_tres[] = { 3.0 };
  double _p_cuatro[] = { 4.0 };
  double _p_cinco[] = { 5.0 };
  double _p_seis[] = { 6.0 };
  double _p_siete[] = { 7.0 };
  double _p_ocho[] = { 8.0 };
  double _p_nueve[] = { 9.0 };
  double _p_diez[] = { 10.0 };
  MF_xfl_singleton uno = new MF_xfl_singleton(min,max,step,_p_uno);
  MF_xfl_singleton dos = new MF_xfl_singleton(min,max,step,_p_dos);
  MF_xfl_singleton tres = new MF_xfl_singleton(min,max,step,_p_tres);
  MF_xfl_singleton cuatro = new MF_xfl_singleton(min,max,step,_p_cuatro);
  MF_xfl_singleton cinco = new MF_xfl_singleton(min,max,step,_p_cinco);
  MF_xfl_singleton seis = new MF_xfl_singleton(min,max,step,_p_seis);
  MF_xfl_singleton siete = new MF_xfl_singleton(min,max,step,_p_siete);
  MF_xfl_singleton ocho = new MF_xfl_singleton(min,max,step,_p_ocho);
  MF_xfl_singleton nueve = new MF_xfl_singleton(min,max,step,_p_nueve);
  MF_xfl_singleton diez = new MF_xfl_singleton(min,max,step,_p_diez);
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Type TP_Antiguedad  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private class TP_Antiguedad {
  private double min = 0.0;
  private double max = 100.0;
  private double step = 1.0101010101010102;
  double _p_estrenar[] = { 0.0,1.0 };
  double _p_muy_nuevo[] = { 1.0,5.0 };
  double _p_poco_nuevo[] = { 20.0,30.0 };
  double _p_antiguo[] = { 75.0,12.5 };
  double _p_muy_antiguo[] = { 100.0,12.5 };
  MF_xfl_bell estrenar = new MF_xfl_bell(min,max,step,_p_estrenar);
  MF_xfl_bell muy_nuevo = new MF_xfl_bell(min,max,step,_p_muy_nuevo);
  MF_xfl_bell poco_nuevo = new MF_xfl_bell(min,max,step,_p_poco_nuevo);
  MF_xfl_bell antiguo = new MF_xfl_bell(min,max,step,_p_antiguo);
  MF_xfl_bell muy_antiguo = new MF_xfl_bell(min,max,step,_p_muy_antiguo);
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Type TP_Metros  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private class TP_Metros {
  private double min = 1.0;
  private double max = 300.0;
  private double step = 1.0;
  double _p_muy_pocos[] = { 1.0,30.0 };
  double _p_pocos[] = { 30.0,60.0 };
  double _p_normal[] = { 60.0,90.0 };
  double _p_bastantes[] = { 90.0,120.0 };
  double _p_mf4[] = { 300.0,90.0 };
  MF_xfl_bell muy_pocos = new MF_xfl_bell(min,max,step,_p_muy_pocos);
  MF_xfl_bell pocos = new MF_xfl_bell(min,max,step,_p_pocos);
  MF_xfl_bell normal = new MF_xfl_bell(min,max,step,_p_normal);
  MF_xfl_bell bastantes = new MF_xfl_bell(min,max,step,_p_bastantes);
  MF_xfl_bell mf4 = new MF_xfl_bell(min,max,step,_p_mf4);
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Type TP_Precio  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private class TP_Precio {
  private double min = 1.0;
  private double max = 1000.0;
  private double step = 1.0;
  double _p_barato[] = { 1.0,149.85 };
  double _p_poco_barato[] = { 250.75,149.85 };
  double _p_normal[] = { 400.0,149.85 };
  double _p_caro[] = { 750.25,400.0 };
  double _p_muy_caro[] = { 1000.0,449.85 };
  MF_xfl_bell barato = new MF_xfl_bell(min,max,step,_p_barato);
  MF_xfl_bell poco_barato = new MF_xfl_bell(min,max,step,_p_poco_barato);
  MF_xfl_bell normal = new MF_xfl_bell(min,max,step,_p_normal);
  MF_xfl_bell caro = new MF_xfl_bell(min,max,step,_p_caro);
  MF_xfl_bell muy_caro = new MF_xfl_bell(min,max,step,_p_muy_caro);
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Type TP_Valoracion  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private class TP_Valoracion {
  private double min = 0.0;
  private double max = 10.0;
  private double step = 1.0;
  double _p_muy_mala[] = { 0.0,1.5 };
  double _p_mala[] = { 2.5,1.5 };
  double _p_regular[] = { 5.0,1.5 };
  double _p_buena[] = { 7.5,1.5 };
  double _p_muy_buena[] = { 10.0,1.5 };
  MF_xfl_bell muy_mala = new MF_xfl_bell(min,max,step,_p_muy_mala);
  MF_xfl_bell mala = new MF_xfl_bell(min,max,step,_p_mala);
  MF_xfl_bell regular = new MF_xfl_bell(min,max,step,_p_regular);
  MF_xfl_bell buena = new MF_xfl_bell(min,max,step,_p_buena);
  MF_xfl_bell muy_buena = new MF_xfl_bell(min,max,step,_p_muy_buena);
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Type TP_Perfil  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private class TP_Perfil {
  private double min = 1.0;
  private double max = 4.0;
  private double step = 0.75;
  double _p_Pareja_joven_sin_hijos[] = { 1.0 };
  double _p_Matrimonio_2_3_hijos[] = { 2.0 };
  double _p_Hombre_soltero[] = { 3.0 };
  double _p_Mujer_soltera[] = { 4.0 };
  MF_xfl_singleton Pareja_joven_sin_hijos = new MF_xfl_singleton(min,max,step,_p_Pareja_joven_sin_hijos);
  MF_xfl_singleton Matrimonio_2_3_hijos = new MF_xfl_singleton(min,max,step,_p_Matrimonio_2_3_hijos);
  MF_xfl_singleton Hombre_soltero = new MF_xfl_singleton(min,max,step,_p_Hombre_soltero);
  MF_xfl_singleton Mujer_soltera = new MF_xfl_singleton(min,max,step,_p_Mujer_soltera);
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Type TP_Orientacion  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private class TP_Orientacion {
  private double min = 1.0;
  private double max = 8.0;
  private double step = 0.875;
  double _p_Norte[] = { 1.0 };
  double _p_Sur[] = { 2.0 };
  double _p_Este[] = { 3.0 };
  double _p_Oeste[] = { 4.0 };
  double _p_Noreste[] = { 5.0 };
  double _p_Noroeste[] = { 6.0 };
  double _p_Sureste[] = { 7.0 };
  double _p_Suroeste[] = { 8.0 };
  MF_xfl_singleton Norte = new MF_xfl_singleton(min,max,step,_p_Norte);
  MF_xfl_singleton Sur = new MF_xfl_singleton(min,max,step,_p_Sur);
  MF_xfl_singleton Este = new MF_xfl_singleton(min,max,step,_p_Este);
  MF_xfl_singleton Oeste = new MF_xfl_singleton(min,max,step,_p_Oeste);
  MF_xfl_singleton Noreste = new MF_xfl_singleton(min,max,step,_p_Noreste);
  MF_xfl_singleton Noroeste = new MF_xfl_singleton(min,max,step,_p_Noroeste);
  MF_xfl_singleton Sureste = new MF_xfl_singleton(min,max,step,_p_Sureste);
  MF_xfl_singleton Suroeste = new MF_xfl_singleton(min,max,step,_p_Suroeste);
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Type TP_Booleano  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private class TP_Booleano {
  private double min = 1.0;
  private double max = 2.0;
  private double step = 0.5;
  double _p_Si[] = { 1.0 };
  double _p_No[] = { 2.0 };
  MF_xfl_singleton Si = new MF_xfl_singleton(min,max,step,_p_Si);
  MF_xfl_singleton No = new MF_xfl_singleton(min,max,step,_p_No);
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_Inferencia_Orientacion  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_Inferencia_Orientacion(MembershipFunction Orientacion, MembershipFunction Perfil) {
  double _rl;
  double _input[] = new double[2];
  if(Orientacion instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) Orientacion).getValue();
  if(Perfil instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) Perfil).getValue();
  OP__default_ _op = new OP__default_();
  OutputMembershipFunction Valoracion_Orientacion = new OutputMembershipFunction();
  Valoracion_Orientacion.set(32,_op,_input);
  TP_Orientacion _t_Orientacion = new TP_Orientacion();
  TP_Perfil _t_Perfil = new TP_Perfil();
  TP_Valoracion _t_Valoracion_Orientacion = new TP_Valoracion();
  int _i_Valoracion_Orientacion=0;
  _rl = _op.and(_t_Orientacion.Norte.isEqual(Orientacion),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.regular); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Norte.isEqual(Orientacion),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.muy_mala); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Norte.isEqual(Orientacion),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.mala); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Norte.isEqual(Orientacion),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.mala); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Sur.isEqual(Orientacion),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.regular); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Sur.isEqual(Orientacion),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.regular); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Sur.isEqual(Orientacion),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.regular); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Sur.isEqual(Orientacion),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.regular); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Este.isEqual(Orientacion),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.buena); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Este.isEqual(Orientacion),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.buena); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Este.isEqual(Orientacion),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.buena); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Este.isEqual(Orientacion),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.buena); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Oeste.isEqual(Orientacion),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.buena); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Oeste.isEqual(Orientacion),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.buena); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Oeste.isEqual(Orientacion),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.buena); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Oeste.isEqual(Orientacion),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.buena); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Noreste.isEqual(Orientacion),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.regular); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Noreste.isEqual(Orientacion),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.muy_mala); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Noreste.isEqual(Orientacion),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.mala); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Noreste.isEqual(Orientacion),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.mala); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Noroeste.isEqual(Orientacion),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.regular); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Noroeste.isEqual(Orientacion),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.muy_mala); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Noroeste.isEqual(Orientacion),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.mala); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Noroeste.isEqual(Orientacion),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.mala); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Sureste.isEqual(Orientacion),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.buena); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Sureste.isEqual(Orientacion),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.buena); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Sureste.isEqual(Orientacion),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.buena); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Sureste.isEqual(Orientacion),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.buena); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Suroeste.isEqual(Orientacion),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.buena); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Suroeste.isEqual(Orientacion),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.buena); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Suroeste.isEqual(Orientacion),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.buena); _i_Valoracion_Orientacion++;
  _rl = _op.and(_t_Orientacion.Suroeste.isEqual(Orientacion),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Orientacion.set(_i_Valoracion_Orientacion,_rl, _t_Valoracion_Orientacion.buena); _i_Valoracion_Orientacion++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = Valoracion_Orientacion;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_Inferencia_Tipo_inmueble  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_Inferencia_Tipo_inmueble(MembershipFunction Tipo_Inmueble, MembershipFunction Perfil) {
  double _rl;
  double _input[] = new double[2];
  if(Tipo_Inmueble instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) Tipo_Inmueble).getValue();
  if(Perfil instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) Perfil).getValue();
  OP__default_ _op = new OP__default_();
  OutputMembershipFunction Valoracion_Tipo_Inmueble = new OutputMembershipFunction();
  Valoracion_Tipo_Inmueble.set(16,_op,_input);
  TP_TipoInmueble _t_Tipo_Inmueble = new TP_TipoInmueble();
  TP_Perfil _t_Perfil = new TP_Perfil();
  TP_Valoracion _t_Valoracion_Tipo_Inmueble = new TP_Valoracion();
  int _i_Valoracion_Tipo_Inmueble=0;
  _rl = _op.and(_t_Tipo_Inmueble.Piso.isEqual(Tipo_Inmueble),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Tipo_Inmueble.set(_i_Valoracion_Tipo_Inmueble,_rl, _t_Valoracion_Tipo_Inmueble.muy_buena); _i_Valoracion_Tipo_Inmueble++;
  _rl = _op.and(_t_Tipo_Inmueble.Piso.isEqual(Tipo_Inmueble),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Tipo_Inmueble.set(_i_Valoracion_Tipo_Inmueble,_rl, _t_Valoracion_Tipo_Inmueble.regular); _i_Valoracion_Tipo_Inmueble++;
  _rl = _op.and(_t_Tipo_Inmueble.Piso.isEqual(Tipo_Inmueble),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Tipo_Inmueble.set(_i_Valoracion_Tipo_Inmueble,_rl, _t_Valoracion_Tipo_Inmueble.muy_buena); _i_Valoracion_Tipo_Inmueble++;
  _rl = _op.and(_t_Tipo_Inmueble.Piso.isEqual(Tipo_Inmueble),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Tipo_Inmueble.set(_i_Valoracion_Tipo_Inmueble,_rl, _t_Valoracion_Tipo_Inmueble.muy_buena); _i_Valoracion_Tipo_Inmueble++;
  _rl = _op.and(_t_Tipo_Inmueble.Adosado.isEqual(Tipo_Inmueble),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Tipo_Inmueble.set(_i_Valoracion_Tipo_Inmueble,_rl, _t_Valoracion_Tipo_Inmueble.muy_buena); _i_Valoracion_Tipo_Inmueble++;
  _rl = _op.and(_t_Tipo_Inmueble.Adosado.isEqual(Tipo_Inmueble),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Tipo_Inmueble.set(_i_Valoracion_Tipo_Inmueble,_rl, _t_Valoracion_Tipo_Inmueble.buena); _i_Valoracion_Tipo_Inmueble++;
  _rl = _op.and(_t_Tipo_Inmueble.Adosado.isEqual(Tipo_Inmueble),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Tipo_Inmueble.set(_i_Valoracion_Tipo_Inmueble,_rl, _t_Valoracion_Tipo_Inmueble.buena); _i_Valoracion_Tipo_Inmueble++;
  _rl = _op.and(_t_Tipo_Inmueble.Adosado.isEqual(Tipo_Inmueble),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Tipo_Inmueble.set(_i_Valoracion_Tipo_Inmueble,_rl, _t_Valoracion_Tipo_Inmueble.buena); _i_Valoracion_Tipo_Inmueble++;
  _rl = _op.and(_t_Tipo_Inmueble.Pareado.isEqual(Tipo_Inmueble),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Tipo_Inmueble.set(_i_Valoracion_Tipo_Inmueble,_rl, _t_Valoracion_Tipo_Inmueble.buena); _i_Valoracion_Tipo_Inmueble++;
  _rl = _op.and(_t_Tipo_Inmueble.Pareado.isEqual(Tipo_Inmueble),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Tipo_Inmueble.set(_i_Valoracion_Tipo_Inmueble,_rl, _t_Valoracion_Tipo_Inmueble.muy_buena); _i_Valoracion_Tipo_Inmueble++;
  _rl = _op.and(_t_Tipo_Inmueble.Pareado.isEqual(Tipo_Inmueble),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Tipo_Inmueble.set(_i_Valoracion_Tipo_Inmueble,_rl, _t_Valoracion_Tipo_Inmueble.regular); _i_Valoracion_Tipo_Inmueble++;
  _rl = _op.and(_t_Tipo_Inmueble.Pareado.isEqual(Tipo_Inmueble),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Tipo_Inmueble.set(_i_Valoracion_Tipo_Inmueble,_rl, _t_Valoracion_Tipo_Inmueble.regular); _i_Valoracion_Tipo_Inmueble++;
  _rl = _op.and(_t_Tipo_Inmueble.Independiente.isEqual(Tipo_Inmueble),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Tipo_Inmueble.set(_i_Valoracion_Tipo_Inmueble,_rl, _t_Valoracion_Tipo_Inmueble.regular); _i_Valoracion_Tipo_Inmueble++;
  _rl = _op.and(_t_Tipo_Inmueble.Independiente.isEqual(Tipo_Inmueble),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Tipo_Inmueble.set(_i_Valoracion_Tipo_Inmueble,_rl, _t_Valoracion_Tipo_Inmueble.muy_buena); _i_Valoracion_Tipo_Inmueble++;
  _rl = _op.and(_t_Tipo_Inmueble.Independiente.isEqual(Tipo_Inmueble),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Tipo_Inmueble.set(_i_Valoracion_Tipo_Inmueble,_rl, _t_Valoracion_Tipo_Inmueble.mala); _i_Valoracion_Tipo_Inmueble++;
  _rl = _op.and(_t_Tipo_Inmueble.Independiente.isEqual(Tipo_Inmueble),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Tipo_Inmueble.set(_i_Valoracion_Tipo_Inmueble,_rl, _t_Valoracion_Tipo_Inmueble.mala); _i_Valoracion_Tipo_Inmueble++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = Valoracion_Tipo_Inmueble;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_Inferencia_Luminosidad  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_Inferencia_Luminosidad(MembershipFunction Luminosidad, MembershipFunction Perfil) {
  double _rl;
  double _input[] = new double[2];
  if(Luminosidad instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) Luminosidad).getValue();
  if(Perfil instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) Perfil).getValue();
  OP__default_ _op = new OP__default_();
  OutputMembershipFunction Valoracion_Luminosidad = new OutputMembershipFunction();
  Valoracion_Luminosidad.set(21,_op,_input);
  TP_Valoracion _t_Luminosidad = new TP_Valoracion();
  TP_Perfil _t_Perfil = new TP_Perfil();
  TP_Valoracion _t_Valoracion_Luminosidad = new TP_Valoracion();
  int _i_Valoracion_Luminosidad=0;
  _rl = _op.and(_t_Luminosidad.muy_mala.isEqual(Luminosidad),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Luminosidad.set(_i_Valoracion_Luminosidad,_rl, _t_Valoracion_Luminosidad.muy_mala); _i_Valoracion_Luminosidad++;
  _rl = _op.and(_t_Luminosidad.muy_mala.isEqual(Luminosidad),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Luminosidad.set(_i_Valoracion_Luminosidad,_rl, _t_Valoracion_Luminosidad.regular); _i_Valoracion_Luminosidad++;
  _rl = _op.and(_t_Luminosidad.muy_mala.isEqual(Luminosidad),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Luminosidad.set(_i_Valoracion_Luminosidad,_rl, _t_Valoracion_Luminosidad.muy_mala); _i_Valoracion_Luminosidad++;
  _rl = _op.and(_t_Luminosidad.muy_mala.isEqual(Luminosidad),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Luminosidad.set(_i_Valoracion_Luminosidad,_rl, _t_Valoracion_Luminosidad.mala); _i_Valoracion_Luminosidad++;
  _rl = _op.and(_t_Luminosidad.muy_mala.isEqual(Luminosidad),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Luminosidad.set(_i_Valoracion_Luminosidad,_rl, _t_Valoracion_Luminosidad.muy_mala); _i_Valoracion_Luminosidad++;
  _rl = _op.and(_t_Luminosidad.mala.isEqual(Luminosidad),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Luminosidad.set(_i_Valoracion_Luminosidad,_rl, _t_Valoracion_Luminosidad.regular); _i_Valoracion_Luminosidad++;
  _rl = _op.and(_t_Luminosidad.mala.isEqual(Luminosidad),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Luminosidad.set(_i_Valoracion_Luminosidad,_rl, _t_Valoracion_Luminosidad.mala); _i_Valoracion_Luminosidad++;
  _rl = _op.and(_t_Luminosidad.mala.isEqual(Luminosidad),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Luminosidad.set(_i_Valoracion_Luminosidad,_rl, _t_Valoracion_Luminosidad.regular); _i_Valoracion_Luminosidad++;
  _rl = _op.and(_t_Luminosidad.mala.isEqual(Luminosidad),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Luminosidad.set(_i_Valoracion_Luminosidad,_rl, _t_Valoracion_Luminosidad.mala); _i_Valoracion_Luminosidad++;
  _rl = _op.and(_t_Luminosidad.regular.isEqual(Luminosidad),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Luminosidad.set(_i_Valoracion_Luminosidad,_rl, _t_Valoracion_Luminosidad.regular); _i_Valoracion_Luminosidad++;
  _rl = _op.and(_t_Luminosidad.regular.isEqual(Luminosidad),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Luminosidad.set(_i_Valoracion_Luminosidad,_rl, _t_Valoracion_Luminosidad.regular); _i_Valoracion_Luminosidad++;
  _rl = _op.and(_t_Luminosidad.regular.isEqual(Luminosidad),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Luminosidad.set(_i_Valoracion_Luminosidad,_rl, _t_Valoracion_Luminosidad.regular); _i_Valoracion_Luminosidad++;
  _rl = _op.and(_t_Luminosidad.regular.isEqual(Luminosidad),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Luminosidad.set(_i_Valoracion_Luminosidad,_rl, _t_Valoracion_Luminosidad.regular); _i_Valoracion_Luminosidad++;
  _rl = _op.and(_t_Luminosidad.buena.isEqual(Luminosidad),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Luminosidad.set(_i_Valoracion_Luminosidad,_rl, _t_Valoracion_Luminosidad.regular); _i_Valoracion_Luminosidad++;
  _rl = _op.and(_t_Luminosidad.buena.isEqual(Luminosidad),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Luminosidad.set(_i_Valoracion_Luminosidad,_rl, _t_Valoracion_Luminosidad.buena); _i_Valoracion_Luminosidad++;
  _rl = _op.and(_t_Luminosidad.buena.isEqual(Luminosidad),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Luminosidad.set(_i_Valoracion_Luminosidad,_rl, _t_Valoracion_Luminosidad.buena); _i_Valoracion_Luminosidad++;
  _rl = _op.and(_t_Luminosidad.buena.isEqual(Luminosidad),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Luminosidad.set(_i_Valoracion_Luminosidad,_rl, _t_Valoracion_Luminosidad.buena); _i_Valoracion_Luminosidad++;
  _rl = _op.and(_t_Luminosidad.muy_buena.isEqual(Luminosidad),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Luminosidad.set(_i_Valoracion_Luminosidad,_rl, _t_Valoracion_Luminosidad.regular); _i_Valoracion_Luminosidad++;
  _rl = _op.and(_t_Luminosidad.muy_buena.isEqual(Luminosidad),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Luminosidad.set(_i_Valoracion_Luminosidad,_rl, _t_Valoracion_Luminosidad.muy_buena); _i_Valoracion_Luminosidad++;
  _rl = _op.and(_t_Luminosidad.muy_buena.isEqual(Luminosidad),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Luminosidad.set(_i_Valoracion_Luminosidad,_rl, _t_Valoracion_Luminosidad.buena); _i_Valoracion_Luminosidad++;
  _rl = _op.and(_t_Luminosidad.muy_buena.isEqual(Luminosidad),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Luminosidad.set(_i_Valoracion_Luminosidad,_rl, _t_Valoracion_Luminosidad.muy_buena); _i_Valoracion_Luminosidad++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = Valoracion_Luminosidad;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_Inferencia_Representatividad  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_Inferencia_Representatividad(MembershipFunction Representatividad, MembershipFunction Perfil) {
  double _rl;
  double _input[] = new double[2];
  if(Representatividad instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) Representatividad).getValue();
  if(Perfil instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) Perfil).getValue();
  OP__default_ _op = new OP__default_();
  OutputMembershipFunction Valoracion_Representatividad = new OutputMembershipFunction();
  Valoracion_Representatividad.set(20,_op,_input);
  TP_Valoracion _t_Representatividad = new TP_Valoracion();
  TP_Perfil _t_Perfil = new TP_Perfil();
  TP_Valoracion _t_Valoracion_Representatividad = new TP_Valoracion();
  int _i_Valoracion_Representatividad=0;
  _rl = _op.and(_t_Representatividad.muy_mala.isEqual(Representatividad),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Representatividad.set(_i_Valoracion_Representatividad,_rl, _t_Valoracion_Representatividad.muy_mala); _i_Valoracion_Representatividad++;
  _rl = _op.and(_t_Representatividad.muy_mala.isEqual(Representatividad),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Representatividad.set(_i_Valoracion_Representatividad,_rl, _t_Valoracion_Representatividad.muy_mala); _i_Valoracion_Representatividad++;
  _rl = _op.and(_t_Representatividad.muy_mala.isEqual(Representatividad),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Representatividad.set(_i_Valoracion_Representatividad,_rl, _t_Valoracion_Representatividad.muy_mala); _i_Valoracion_Representatividad++;
  _rl = _op.and(_t_Representatividad.muy_mala.isEqual(Representatividad),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Representatividad.set(_i_Valoracion_Representatividad,_rl, _t_Valoracion_Representatividad.mala); _i_Valoracion_Representatividad++;
  _rl = _op.and(_t_Representatividad.mala.isEqual(Representatividad),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Representatividad.set(_i_Valoracion_Representatividad,_rl, _t_Valoracion_Representatividad.mala); _i_Valoracion_Representatividad++;
  _rl = _op.and(_t_Representatividad.mala.isEqual(Representatividad),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Representatividad.set(_i_Valoracion_Representatividad,_rl, _t_Valoracion_Representatividad.mala); _i_Valoracion_Representatividad++;
  _rl = _op.and(_t_Representatividad.mala.isEqual(Representatividad),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Representatividad.set(_i_Valoracion_Representatividad,_rl, _t_Valoracion_Representatividad.mala); _i_Valoracion_Representatividad++;
  _rl = _op.and(_t_Representatividad.mala.isEqual(Representatividad),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Representatividad.set(_i_Valoracion_Representatividad,_rl, _t_Valoracion_Representatividad.regular); _i_Valoracion_Representatividad++;
  _rl = _op.and(_t_Representatividad.regular.isEqual(Representatividad),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Representatividad.set(_i_Valoracion_Representatividad,_rl, _t_Valoracion_Representatividad.regular); _i_Valoracion_Representatividad++;
  _rl = _op.and(_t_Representatividad.regular.isEqual(Representatividad),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Representatividad.set(_i_Valoracion_Representatividad,_rl, _t_Valoracion_Representatividad.regular); _i_Valoracion_Representatividad++;
  _rl = _op.and(_t_Representatividad.regular.isEqual(Representatividad),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Representatividad.set(_i_Valoracion_Representatividad,_rl, _t_Valoracion_Representatividad.regular); _i_Valoracion_Representatividad++;
  _rl = _op.and(_t_Representatividad.regular.isEqual(Representatividad),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Representatividad.set(_i_Valoracion_Representatividad,_rl, _t_Valoracion_Representatividad.regular); _i_Valoracion_Representatividad++;
  _rl = _op.and(_t_Representatividad.buena.isEqual(Representatividad),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Representatividad.set(_i_Valoracion_Representatividad,_rl, _t_Valoracion_Representatividad.buena); _i_Valoracion_Representatividad++;
  _rl = _op.and(_t_Representatividad.buena.isEqual(Representatividad),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Representatividad.set(_i_Valoracion_Representatividad,_rl, _t_Valoracion_Representatividad.buena); _i_Valoracion_Representatividad++;
  _rl = _op.and(_t_Representatividad.buena.isEqual(Representatividad),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Representatividad.set(_i_Valoracion_Representatividad,_rl, _t_Valoracion_Representatividad.buena); _i_Valoracion_Representatividad++;
  _rl = _op.and(_t_Representatividad.buena.isEqual(Representatividad),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Representatividad.set(_i_Valoracion_Representatividad,_rl, _t_Valoracion_Representatividad.buena); _i_Valoracion_Representatividad++;
  _rl = _op.and(_t_Representatividad.muy_buena.isEqual(Representatividad),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Representatividad.set(_i_Valoracion_Representatividad,_rl, _t_Valoracion_Representatividad.muy_buena); _i_Valoracion_Representatividad++;
  _rl = _op.and(_t_Representatividad.muy_buena.isEqual(Representatividad),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Representatividad.set(_i_Valoracion_Representatividad,_rl, _t_Valoracion_Representatividad.muy_buena); _i_Valoracion_Representatividad++;
  _rl = _op.and(_t_Representatividad.muy_buena.isEqual(Representatividad),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Representatividad.set(_i_Valoracion_Representatividad,_rl, _t_Valoracion_Representatividad.muy_buena); _i_Valoracion_Representatividad++;
  _rl = _op.and(_t_Representatividad.muy_buena.isEqual(Representatividad),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Representatividad.set(_i_Valoracion_Representatividad,_rl, _t_Valoracion_Representatividad.buena); _i_Valoracion_Representatividad++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = Valoracion_Representatividad;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_Inferencia_Estado_del_portal  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_Inferencia_Estado_del_portal(MembershipFunction Estado_del_portal, MembershipFunction Perfil) {
  double _rl;
  double _input[] = new double[2];
  if(Estado_del_portal instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) Estado_del_portal).getValue();
  if(Perfil instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) Perfil).getValue();
  OP__default_ _op = new OP__default_();
  OutputMembershipFunction Valoracion_estado_del_portal = new OutputMembershipFunction();
  Valoracion_estado_del_portal.set(20,_op,_input);
  TP_Valoracion _t_Estado_del_portal = new TP_Valoracion();
  TP_Perfil _t_Perfil = new TP_Perfil();
  TP_Valoracion _t_Valoracion_estado_del_portal = new TP_Valoracion();
  int _i_Valoracion_estado_del_portal=0;
  _rl = _op.and(_t_Estado_del_portal.muy_mala.isEqual(Estado_del_portal),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_estado_del_portal.set(_i_Valoracion_estado_del_portal,_rl, _t_Valoracion_estado_del_portal.mala); _i_Valoracion_estado_del_portal++;
  _rl = _op.and(_t_Estado_del_portal.muy_mala.isEqual(Estado_del_portal),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_estado_del_portal.set(_i_Valoracion_estado_del_portal,_rl, _t_Valoracion_estado_del_portal.muy_mala); _i_Valoracion_estado_del_portal++;
  _rl = _op.and(_t_Estado_del_portal.muy_mala.isEqual(Estado_del_portal),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_estado_del_portal.set(_i_Valoracion_estado_del_portal,_rl, _t_Valoracion_estado_del_portal.muy_mala); _i_Valoracion_estado_del_portal++;
  _rl = _op.and(_t_Estado_del_portal.muy_mala.isEqual(Estado_del_portal),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_estado_del_portal.set(_i_Valoracion_estado_del_portal,_rl, _t_Valoracion_estado_del_portal.mala); _i_Valoracion_estado_del_portal++;
  _rl = _op.and(_t_Estado_del_portal.mala.isEqual(Estado_del_portal),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_estado_del_portal.set(_i_Valoracion_estado_del_portal,_rl, _t_Valoracion_estado_del_portal.mala); _i_Valoracion_estado_del_portal++;
  _rl = _op.and(_t_Estado_del_portal.mala.isEqual(Estado_del_portal),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_estado_del_portal.set(_i_Valoracion_estado_del_portal,_rl, _t_Valoracion_estado_del_portal.mala); _i_Valoracion_estado_del_portal++;
  _rl = _op.and(_t_Estado_del_portal.mala.isEqual(Estado_del_portal),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_estado_del_portal.set(_i_Valoracion_estado_del_portal,_rl, _t_Valoracion_estado_del_portal.mala); _i_Valoracion_estado_del_portal++;
  _rl = _op.and(_t_Estado_del_portal.mala.isEqual(Estado_del_portal),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_estado_del_portal.set(_i_Valoracion_estado_del_portal,_rl, _t_Valoracion_estado_del_portal.mala); _i_Valoracion_estado_del_portal++;
  _rl = _op.and(_t_Estado_del_portal.regular.isEqual(Estado_del_portal),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_estado_del_portal.set(_i_Valoracion_estado_del_portal,_rl, _t_Valoracion_estado_del_portal.regular); _i_Valoracion_estado_del_portal++;
  _rl = _op.and(_t_Estado_del_portal.regular.isEqual(Estado_del_portal),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_estado_del_portal.set(_i_Valoracion_estado_del_portal,_rl, _t_Valoracion_estado_del_portal.regular); _i_Valoracion_estado_del_portal++;
  _rl = _op.and(_t_Estado_del_portal.regular.isEqual(Estado_del_portal),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_estado_del_portal.set(_i_Valoracion_estado_del_portal,_rl, _t_Valoracion_estado_del_portal.regular); _i_Valoracion_estado_del_portal++;
  _rl = _op.and(_t_Estado_del_portal.regular.isEqual(Estado_del_portal),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_estado_del_portal.set(_i_Valoracion_estado_del_portal,_rl, _t_Valoracion_estado_del_portal.regular); _i_Valoracion_estado_del_portal++;
  _rl = _op.and(_t_Estado_del_portal.buena.isEqual(Estado_del_portal),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_estado_del_portal.set(_i_Valoracion_estado_del_portal,_rl, _t_Valoracion_estado_del_portal.regular); _i_Valoracion_estado_del_portal++;
  _rl = _op.and(_t_Estado_del_portal.buena.isEqual(Estado_del_portal),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_estado_del_portal.set(_i_Valoracion_estado_del_portal,_rl, _t_Valoracion_estado_del_portal.buena); _i_Valoracion_estado_del_portal++;
  _rl = _op.and(_t_Estado_del_portal.buena.isEqual(Estado_del_portal),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_estado_del_portal.set(_i_Valoracion_estado_del_portal,_rl, _t_Valoracion_estado_del_portal.buena); _i_Valoracion_estado_del_portal++;
  _rl = _op.and(_t_Estado_del_portal.buena.isEqual(Estado_del_portal),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_estado_del_portal.set(_i_Valoracion_estado_del_portal,_rl, _t_Valoracion_estado_del_portal.regular); _i_Valoracion_estado_del_portal++;
  _rl = _op.and(_t_Estado_del_portal.muy_buena.isEqual(Estado_del_portal),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_estado_del_portal.set(_i_Valoracion_estado_del_portal,_rl, _t_Valoracion_estado_del_portal.buena); _i_Valoracion_estado_del_portal++;
  _rl = _op.and(_t_Estado_del_portal.muy_buena.isEqual(Estado_del_portal),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_estado_del_portal.set(_i_Valoracion_estado_del_portal,_rl, _t_Valoracion_estado_del_portal.muy_buena); _i_Valoracion_estado_del_portal++;
  _rl = _op.and(_t_Estado_del_portal.muy_buena.isEqual(Estado_del_portal),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_estado_del_portal.set(_i_Valoracion_estado_del_portal,_rl, _t_Valoracion_estado_del_portal.muy_buena); _i_Valoracion_estado_del_portal++;
  _rl = _op.and(_t_Estado_del_portal.muy_buena.isEqual(Estado_del_portal),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_estado_del_portal.set(_i_Valoracion_estado_del_portal,_rl, _t_Valoracion_estado_del_portal.buena); _i_Valoracion_estado_del_portal++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = Valoracion_estado_del_portal;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_Inferencia_Fachada  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_Inferencia_Fachada(MembershipFunction Fachada, MembershipFunction Perfil) {
  double _rl;
  double _input[] = new double[2];
  if(Fachada instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) Fachada).getValue();
  if(Perfil instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) Perfil).getValue();
  OP__default_ _op = new OP__default_();
  OutputMembershipFunction Valoracion_Fachada = new OutputMembershipFunction();
  Valoracion_Fachada.set(20,_op,_input);
  TP_Valoracion _t_Fachada = new TP_Valoracion();
  TP_Perfil _t_Perfil = new TP_Perfil();
  TP_Valoracion _t_Valoracion_Fachada = new TP_Valoracion();
  int _i_Valoracion_Fachada=0;
  _rl = _op.and(_t_Fachada.muy_mala.isEqual(Fachada),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Fachada.set(_i_Valoracion_Fachada,_rl, _t_Valoracion_Fachada.muy_mala); _i_Valoracion_Fachada++;
  _rl = _op.and(_t_Fachada.muy_mala.isEqual(Fachada),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Fachada.set(_i_Valoracion_Fachada,_rl, _t_Valoracion_Fachada.mala); _i_Valoracion_Fachada++;
  _rl = _op.and(_t_Fachada.muy_mala.isEqual(Fachada),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Fachada.set(_i_Valoracion_Fachada,_rl, _t_Valoracion_Fachada.muy_mala); _i_Valoracion_Fachada++;
  _rl = _op.and(_t_Fachada.muy_mala.isEqual(Fachada),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Fachada.set(_i_Valoracion_Fachada,_rl, _t_Valoracion_Fachada.mala); _i_Valoracion_Fachada++;
  _rl = _op.and(_t_Fachada.mala.isEqual(Fachada),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Fachada.set(_i_Valoracion_Fachada,_rl, _t_Valoracion_Fachada.mala); _i_Valoracion_Fachada++;
  _rl = _op.and(_t_Fachada.mala.isEqual(Fachada),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Fachada.set(_i_Valoracion_Fachada,_rl, _t_Valoracion_Fachada.regular); _i_Valoracion_Fachada++;
  _rl = _op.and(_t_Fachada.mala.isEqual(Fachada),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Fachada.set(_i_Valoracion_Fachada,_rl, _t_Valoracion_Fachada.mala); _i_Valoracion_Fachada++;
  _rl = _op.and(_t_Fachada.mala.isEqual(Fachada),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Fachada.set(_i_Valoracion_Fachada,_rl, _t_Valoracion_Fachada.regular); _i_Valoracion_Fachada++;
  _rl = _op.and(_t_Fachada.regular.isEqual(Fachada),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Fachada.set(_i_Valoracion_Fachada,_rl, _t_Valoracion_Fachada.regular); _i_Valoracion_Fachada++;
  _rl = _op.and(_t_Fachada.regular.isEqual(Fachada),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Fachada.set(_i_Valoracion_Fachada,_rl, _t_Valoracion_Fachada.regular); _i_Valoracion_Fachada++;
  _rl = _op.and(_t_Fachada.regular.isEqual(Fachada),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Fachada.set(_i_Valoracion_Fachada,_rl, _t_Valoracion_Fachada.regular); _i_Valoracion_Fachada++;
  _rl = _op.and(_t_Fachada.regular.isEqual(Fachada),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Fachada.set(_i_Valoracion_Fachada,_rl, _t_Valoracion_Fachada.regular); _i_Valoracion_Fachada++;
  _rl = _op.and(_t_Fachada.buena.isEqual(Fachada),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Fachada.set(_i_Valoracion_Fachada,_rl, _t_Valoracion_Fachada.buena); _i_Valoracion_Fachada++;
  _rl = _op.and(_t_Fachada.buena.isEqual(Fachada),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Fachada.set(_i_Valoracion_Fachada,_rl, _t_Valoracion_Fachada.buena); _i_Valoracion_Fachada++;
  _rl = _op.and(_t_Fachada.buena.isEqual(Fachada),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Fachada.set(_i_Valoracion_Fachada,_rl, _t_Valoracion_Fachada.buena); _i_Valoracion_Fachada++;
  _rl = _op.and(_t_Fachada.buena.isEqual(Fachada),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Fachada.set(_i_Valoracion_Fachada,_rl, _t_Valoracion_Fachada.buena); _i_Valoracion_Fachada++;
  _rl = _op.and(_t_Fachada.muy_buena.isEqual(Fachada),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Fachada.set(_i_Valoracion_Fachada,_rl, _t_Valoracion_Fachada.muy_buena); _i_Valoracion_Fachada++;
  _rl = _op.and(_t_Fachada.muy_buena.isEqual(Fachada),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Fachada.set(_i_Valoracion_Fachada,_rl, _t_Valoracion_Fachada.buena); _i_Valoracion_Fachada++;
  _rl = _op.and(_t_Fachada.muy_buena.isEqual(Fachada),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Fachada.set(_i_Valoracion_Fachada,_rl, _t_Valoracion_Fachada.muy_buena); _i_Valoracion_Fachada++;
  _rl = _op.and(_t_Fachada.muy_buena.isEqual(Fachada),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Fachada.set(_i_Valoracion_Fachada,_rl, _t_Valoracion_Fachada.buena); _i_Valoracion_Fachada++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = Valoracion_Fachada;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_Inferencia_Vistas  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_Inferencia_Vistas(MembershipFunction Vistas, MembershipFunction Perfil) {
  double _rl;
  double _input[] = new double[2];
  if(Vistas instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) Vistas).getValue();
  if(Perfil instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) Perfil).getValue();
  OP__default_ _op = new OP__default_();
  OutputMembershipFunction Valoracion_Vistas = new OutputMembershipFunction();
  Valoracion_Vistas.set(20,_op,_input);
  TP_Valoracion _t_Vistas = new TP_Valoracion();
  TP_Perfil _t_Perfil = new TP_Perfil();
  TP_Valoracion _t_Valoracion_Vistas = new TP_Valoracion();
  int _i_Valoracion_Vistas=0;
  _rl = _op.and(_t_Vistas.muy_mala.isEqual(Vistas),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Vistas.set(_i_Valoracion_Vistas,_rl, _t_Valoracion_Vistas.muy_mala); _i_Valoracion_Vistas++;
  _rl = _op.and(_t_Vistas.muy_mala.isEqual(Vistas),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Vistas.set(_i_Valoracion_Vistas,_rl, _t_Valoracion_Vistas.mala); _i_Valoracion_Vistas++;
  _rl = _op.and(_t_Vistas.muy_mala.isEqual(Vistas),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Vistas.set(_i_Valoracion_Vistas,_rl, _t_Valoracion_Vistas.muy_mala); _i_Valoracion_Vistas++;
  _rl = _op.and(_t_Vistas.muy_mala.isEqual(Vistas),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Vistas.set(_i_Valoracion_Vistas,_rl, _t_Valoracion_Vistas.mala); _i_Valoracion_Vistas++;
  _rl = _op.and(_t_Vistas.mala.isEqual(Vistas),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Vistas.set(_i_Valoracion_Vistas,_rl, _t_Valoracion_Vistas.mala); _i_Valoracion_Vistas++;
  _rl = _op.and(_t_Vistas.mala.isEqual(Vistas),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Vistas.set(_i_Valoracion_Vistas,_rl, _t_Valoracion_Vistas.regular); _i_Valoracion_Vistas++;
  _rl = _op.and(_t_Vistas.mala.isEqual(Vistas),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Vistas.set(_i_Valoracion_Vistas,_rl, _t_Valoracion_Vistas.mala); _i_Valoracion_Vistas++;
  _rl = _op.and(_t_Vistas.mala.isEqual(Vistas),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Vistas.set(_i_Valoracion_Vistas,_rl, _t_Valoracion_Vistas.regular); _i_Valoracion_Vistas++;
  _rl = _op.and(_t_Vistas.regular.isEqual(Vistas),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Vistas.set(_i_Valoracion_Vistas,_rl, _t_Valoracion_Vistas.regular); _i_Valoracion_Vistas++;
  _rl = _op.and(_t_Vistas.regular.isEqual(Vistas),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Vistas.set(_i_Valoracion_Vistas,_rl, _t_Valoracion_Vistas.regular); _i_Valoracion_Vistas++;
  _rl = _op.and(_t_Vistas.regular.isEqual(Vistas),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Vistas.set(_i_Valoracion_Vistas,_rl, _t_Valoracion_Vistas.regular); _i_Valoracion_Vistas++;
  _rl = _op.and(_t_Vistas.regular.isEqual(Vistas),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Vistas.set(_i_Valoracion_Vistas,_rl, _t_Valoracion_Vistas.regular); _i_Valoracion_Vistas++;
  _rl = _op.and(_t_Vistas.buena.isEqual(Vistas),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Vistas.set(_i_Valoracion_Vistas,_rl, _t_Valoracion_Vistas.buena); _i_Valoracion_Vistas++;
  _rl = _op.and(_t_Vistas.buena.isEqual(Vistas),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Vistas.set(_i_Valoracion_Vistas,_rl, _t_Valoracion_Vistas.buena); _i_Valoracion_Vistas++;
  _rl = _op.and(_t_Vistas.buena.isEqual(Vistas),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Vistas.set(_i_Valoracion_Vistas,_rl, _t_Valoracion_Vistas.buena); _i_Valoracion_Vistas++;
  _rl = _op.and(_t_Vistas.buena.isEqual(Vistas),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Vistas.set(_i_Valoracion_Vistas,_rl, _t_Valoracion_Vistas.buena); _i_Valoracion_Vistas++;
  _rl = _op.and(_t_Vistas.muy_buena.isEqual(Vistas),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Vistas.set(_i_Valoracion_Vistas,_rl, _t_Valoracion_Vistas.muy_buena); _i_Valoracion_Vistas++;
  _rl = _op.and(_t_Vistas.muy_buena.isEqual(Vistas),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Vistas.set(_i_Valoracion_Vistas,_rl, _t_Valoracion_Vistas.buena); _i_Valoracion_Vistas++;
  _rl = _op.and(_t_Vistas.muy_buena.isEqual(Vistas),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Vistas.set(_i_Valoracion_Vistas,_rl, _t_Valoracion_Vistas.muy_buena); _i_Valoracion_Vistas++;
  _rl = _op.and(_t_Vistas.muy_buena.isEqual(Vistas),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Vistas.set(_i_Valoracion_Vistas,_rl, _t_Valoracion_Vistas.buena); _i_Valoracion_Vistas++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = Valoracion_Vistas;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_Inferencia_Numero_habitaciones  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_Inferencia_Numero_habitaciones(MembershipFunction Numero_habitaciones, MembershipFunction Perfil) {
  double _rl;
  double _input[] = new double[2];
  if(Numero_habitaciones instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) Numero_habitaciones).getValue();
  if(Perfil instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) Perfil).getValue();
  OP__default_ _op = new OP__default_();
  OutputMembershipFunction Valoracion_numero_habitaciones = new OutputMembershipFunction();
  Valoracion_numero_habitaciones.set(40,_op,_input);
  TP_Numero _t_Numero_habitaciones = new TP_Numero();
  TP_Perfil _t_Perfil = new TP_Perfil();
  TP_Valoracion _t_Valoracion_numero_habitaciones = new TP_Valoracion();
  int _i_Valoracion_numero_habitaciones=0;
  _rl = _op.and(_t_Numero_habitaciones.uno.isEqual(Numero_habitaciones),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.regular); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.uno.isEqual(Numero_habitaciones),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.uno.isEqual(Numero_habitaciones),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.regular); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.uno.isEqual(Numero_habitaciones),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.regular); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.dos.isEqual(Numero_habitaciones),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.buena); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.dos.isEqual(Numero_habitaciones),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.dos.isEqual(Numero_habitaciones),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_buena); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.dos.isEqual(Numero_habitaciones),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_buena); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.tres.isEqual(Numero_habitaciones),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_buena); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.tres.isEqual(Numero_habitaciones),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.buena); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.tres.isEqual(Numero_habitaciones),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_buena); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.tres.isEqual(Numero_habitaciones),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.buena); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.cuatro.isEqual(Numero_habitaciones),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.buena); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.cuatro.isEqual(Numero_habitaciones),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_buena); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.cuatro.isEqual(Numero_habitaciones),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.cuatro.isEqual(Numero_habitaciones),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.cinco.isEqual(Numero_habitaciones),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.regular); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.cinco.isEqual(Numero_habitaciones),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_buena); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.cinco.isEqual(Numero_habitaciones),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.cinco.isEqual(Numero_habitaciones),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.seis.isEqual(Numero_habitaciones),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.seis.isEqual(Numero_habitaciones),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_buena); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.seis.isEqual(Numero_habitaciones),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.seis.isEqual(Numero_habitaciones),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.siete.isEqual(Numero_habitaciones),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.siete.isEqual(Numero_habitaciones),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_buena); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.siete.isEqual(Numero_habitaciones),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.siete.isEqual(Numero_habitaciones),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.ocho.isEqual(Numero_habitaciones),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.ocho.isEqual(Numero_habitaciones),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.ocho.isEqual(Numero_habitaciones),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.ocho.isEqual(Numero_habitaciones),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.nueve.isEqual(Numero_habitaciones),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.nueve.isEqual(Numero_habitaciones),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.nueve.isEqual(Numero_habitaciones),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.nueve.isEqual(Numero_habitaciones),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.diez.isEqual(Numero_habitaciones),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.diez.isEqual(Numero_habitaciones),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.diez.isEqual(Numero_habitaciones),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_mala); _i_Valoracion_numero_habitaciones++;
  _rl = _op.and(_t_Numero_habitaciones.diez.isEqual(Numero_habitaciones),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_numero_habitaciones.set(_i_Valoracion_numero_habitaciones,_rl, _t_Valoracion_numero_habitaciones.muy_mala); _i_Valoracion_numero_habitaciones++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = Valoracion_numero_habitaciones;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_Inferencia_Numero_banos  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_Inferencia_Numero_banos(MembershipFunction Numero_banos, MembershipFunction Perfil) {
  double _rl;
  double _input[] = new double[2];
  if(Numero_banos instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) Numero_banos).getValue();
  if(Perfil instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) Perfil).getValue();
  OP__default_ _op = new OP__default_();
  OutputMembershipFunction Valoracion_Numero_banos = new OutputMembershipFunction();
  Valoracion_Numero_banos.set(20,_op,_input);
  TP_Numero _t_Numero_banos = new TP_Numero();
  TP_Perfil _t_Perfil = new TP_Perfil();
  TP_Valoracion _t_Valoracion_Numero_banos = new TP_Valoracion();
  int _i_Valoracion_Numero_banos=0;
  _rl = _op.and(_t_Numero_banos.uno.isEqual(Numero_banos),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Numero_banos.set(_i_Valoracion_Numero_banos,_rl, _t_Valoracion_Numero_banos.regular); _i_Valoracion_Numero_banos++;
  _rl = _op.and(_t_Numero_banos.uno.isEqual(Numero_banos),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Numero_banos.set(_i_Valoracion_Numero_banos,_rl, _t_Valoracion_Numero_banos.muy_mala); _i_Valoracion_Numero_banos++;
  _rl = _op.and(_t_Numero_banos.uno.isEqual(Numero_banos),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Numero_banos.set(_i_Valoracion_Numero_banos,_rl, _t_Valoracion_Numero_banos.regular); _i_Valoracion_Numero_banos++;
  _rl = _op.and(_t_Numero_banos.uno.isEqual(Numero_banos),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Numero_banos.set(_i_Valoracion_Numero_banos,_rl, _t_Valoracion_Numero_banos.regular); _i_Valoracion_Numero_banos++;
  _rl = _op.and(_t_Numero_banos.dos.isEqual(Numero_banos),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Numero_banos.set(_i_Valoracion_Numero_banos,_rl, _t_Valoracion_Numero_banos.buena); _i_Valoracion_Numero_banos++;
  _rl = _op.and(_t_Numero_banos.dos.isEqual(Numero_banos),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Numero_banos.set(_i_Valoracion_Numero_banos,_rl, _t_Valoracion_Numero_banos.regular); _i_Valoracion_Numero_banos++;
  _rl = _op.and(_t_Numero_banos.dos.isEqual(Numero_banos),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Numero_banos.set(_i_Valoracion_Numero_banos,_rl, _t_Valoracion_Numero_banos.muy_buena); _i_Valoracion_Numero_banos++;
  _rl = _op.and(_t_Numero_banos.dos.isEqual(Numero_banos),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Numero_banos.set(_i_Valoracion_Numero_banos,_rl, _t_Valoracion_Numero_banos.muy_buena); _i_Valoracion_Numero_banos++;
  _rl = _op.and(_t_Numero_banos.tres.isEqual(Numero_banos),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Numero_banos.set(_i_Valoracion_Numero_banos,_rl, _t_Valoracion_Numero_banos.muy_buena); _i_Valoracion_Numero_banos++;
  _rl = _op.and(_t_Numero_banos.tres.isEqual(Numero_banos),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Numero_banos.set(_i_Valoracion_Numero_banos,_rl, _t_Valoracion_Numero_banos.muy_buena); _i_Valoracion_Numero_banos++;
  _rl = _op.and(_t_Numero_banos.tres.isEqual(Numero_banos),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Numero_banos.set(_i_Valoracion_Numero_banos,_rl, _t_Valoracion_Numero_banos.mala); _i_Valoracion_Numero_banos++;
  _rl = _op.and(_t_Numero_banos.tres.isEqual(Numero_banos),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Numero_banos.set(_i_Valoracion_Numero_banos,_rl, _t_Valoracion_Numero_banos.mala); _i_Valoracion_Numero_banos++;
  _rl = _op.and(_t_Numero_banos.cuatro.isEqual(Numero_banos),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Numero_banos.set(_i_Valoracion_Numero_banos,_rl, _t_Valoracion_Numero_banos.muy_mala); _i_Valoracion_Numero_banos++;
  _rl = _op.and(_t_Numero_banos.cuatro.isEqual(Numero_banos),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Numero_banos.set(_i_Valoracion_Numero_banos,_rl, _t_Valoracion_Numero_banos.muy_buena); _i_Valoracion_Numero_banos++;
  _rl = _op.and(_t_Numero_banos.cuatro.isEqual(Numero_banos),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Numero_banos.set(_i_Valoracion_Numero_banos,_rl, _t_Valoracion_Numero_banos.muy_mala); _i_Valoracion_Numero_banos++;
  _rl = _op.and(_t_Numero_banos.cuatro.isEqual(Numero_banos),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Numero_banos.set(_i_Valoracion_Numero_banos,_rl, _t_Valoracion_Numero_banos.muy_mala); _i_Valoracion_Numero_banos++;
  _rl = _op.and(_t_Numero_banos.cinco.isEqual(Numero_banos),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Numero_banos.set(_i_Valoracion_Numero_banos,_rl, _t_Valoracion_Numero_banos.muy_mala); _i_Valoracion_Numero_banos++;
  _rl = _op.and(_t_Numero_banos.cinco.isEqual(Numero_banos),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Numero_banos.set(_i_Valoracion_Numero_banos,_rl, _t_Valoracion_Numero_banos.muy_buena); _i_Valoracion_Numero_banos++;
  _rl = _op.and(_t_Numero_banos.cinco.isEqual(Numero_banos),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Numero_banos.set(_i_Valoracion_Numero_banos,_rl, _t_Valoracion_Numero_banos.muy_mala); _i_Valoracion_Numero_banos++;
  _rl = _op.and(_t_Numero_banos.cinco.isEqual(Numero_banos),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Numero_banos.set(_i_Valoracion_Numero_banos,_rl, _t_Valoracion_Numero_banos.muy_mala); _i_Valoracion_Numero_banos++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = Valoracion_Numero_banos;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_Inferencia_Antiguedad  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_Inferencia_Antiguedad(MembershipFunction Antiguedad, MembershipFunction Perfil) {
  double _rl;
  double _input[] = new double[2];
  if(Antiguedad instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) Antiguedad).getValue();
  if(Perfil instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) Perfil).getValue();
  OP__default_ _op = new OP__default_();
  OutputMembershipFunction Valoracion_Antiguedad = new OutputMembershipFunction();
  Valoracion_Antiguedad.set(20,_op,_input);
  TP_Antiguedad _t_Antiguedad = new TP_Antiguedad();
  TP_Perfil _t_Perfil = new TP_Perfil();
  TP_Valoracion _t_Valoracion_Antiguedad = new TP_Valoracion();
  int _i_Valoracion_Antiguedad=0;
  _rl = _op.and(_t_Antiguedad.estrenar.isEqual(Antiguedad),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Antiguedad.set(_i_Valoracion_Antiguedad,_rl, _t_Valoracion_Antiguedad.muy_buena); _i_Valoracion_Antiguedad++;
  _rl = _op.and(_t_Antiguedad.estrenar.isEqual(Antiguedad),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Antiguedad.set(_i_Valoracion_Antiguedad,_rl, _t_Valoracion_Antiguedad.muy_buena); _i_Valoracion_Antiguedad++;
  _rl = _op.and(_t_Antiguedad.estrenar.isEqual(Antiguedad),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Antiguedad.set(_i_Valoracion_Antiguedad,_rl, _t_Valoracion_Antiguedad.muy_buena); _i_Valoracion_Antiguedad++;
  _rl = _op.and(_t_Antiguedad.estrenar.isEqual(Antiguedad),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Antiguedad.set(_i_Valoracion_Antiguedad,_rl, _t_Valoracion_Antiguedad.muy_buena); _i_Valoracion_Antiguedad++;
  _rl = _op.and(_t_Antiguedad.muy_nuevo.isEqual(Antiguedad),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Antiguedad.set(_i_Valoracion_Antiguedad,_rl, _t_Valoracion_Antiguedad.muy_buena); _i_Valoracion_Antiguedad++;
  _rl = _op.and(_t_Antiguedad.muy_nuevo.isEqual(Antiguedad),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Antiguedad.set(_i_Valoracion_Antiguedad,_rl, _t_Valoracion_Antiguedad.muy_buena); _i_Valoracion_Antiguedad++;
  _rl = _op.and(_t_Antiguedad.muy_nuevo.isEqual(Antiguedad),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Antiguedad.set(_i_Valoracion_Antiguedad,_rl, _t_Valoracion_Antiguedad.muy_buena); _i_Valoracion_Antiguedad++;
  _rl = _op.and(_t_Antiguedad.muy_nuevo.isEqual(Antiguedad),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Antiguedad.set(_i_Valoracion_Antiguedad,_rl, _t_Valoracion_Antiguedad.muy_buena); _i_Valoracion_Antiguedad++;
  _rl = _op.and(_t_Antiguedad.poco_nuevo.isEqual(Antiguedad),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Antiguedad.set(_i_Valoracion_Antiguedad,_rl, _t_Valoracion_Antiguedad.regular); _i_Valoracion_Antiguedad++;
  _rl = _op.and(_t_Antiguedad.poco_nuevo.isEqual(Antiguedad),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Antiguedad.set(_i_Valoracion_Antiguedad,_rl, _t_Valoracion_Antiguedad.regular); _i_Valoracion_Antiguedad++;
  _rl = _op.and(_t_Antiguedad.poco_nuevo.isEqual(Antiguedad),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Antiguedad.set(_i_Valoracion_Antiguedad,_rl, _t_Valoracion_Antiguedad.regular); _i_Valoracion_Antiguedad++;
  _rl = _op.and(_t_Antiguedad.poco_nuevo.isEqual(Antiguedad),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Antiguedad.set(_i_Valoracion_Antiguedad,_rl, _t_Valoracion_Antiguedad.regular); _i_Valoracion_Antiguedad++;
  _rl = _op.and(_t_Antiguedad.antiguo.isEqual(Antiguedad),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Antiguedad.set(_i_Valoracion_Antiguedad,_rl, _t_Valoracion_Antiguedad.mala); _i_Valoracion_Antiguedad++;
  _rl = _op.and(_t_Antiguedad.antiguo.isEqual(Antiguedad),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Antiguedad.set(_i_Valoracion_Antiguedad,_rl, _t_Valoracion_Antiguedad.mala); _i_Valoracion_Antiguedad++;
  _rl = _op.and(_t_Antiguedad.antiguo.isEqual(Antiguedad),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Antiguedad.set(_i_Valoracion_Antiguedad,_rl, _t_Valoracion_Antiguedad.mala); _i_Valoracion_Antiguedad++;
  _rl = _op.and(_t_Antiguedad.antiguo.isEqual(Antiguedad),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Antiguedad.set(_i_Valoracion_Antiguedad,_rl, _t_Valoracion_Antiguedad.mala); _i_Valoracion_Antiguedad++;
  _rl = _op.and(_t_Antiguedad.muy_antiguo.isEqual(Antiguedad),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Antiguedad.set(_i_Valoracion_Antiguedad,_rl, _t_Valoracion_Antiguedad.muy_mala); _i_Valoracion_Antiguedad++;
  _rl = _op.and(_t_Antiguedad.muy_antiguo.isEqual(Antiguedad),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Antiguedad.set(_i_Valoracion_Antiguedad,_rl, _t_Valoracion_Antiguedad.muy_mala); _i_Valoracion_Antiguedad++;
  _rl = _op.and(_t_Antiguedad.muy_antiguo.isEqual(Antiguedad),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Antiguedad.set(_i_Valoracion_Antiguedad,_rl, _t_Valoracion_Antiguedad.muy_mala); _i_Valoracion_Antiguedad++;
  _rl = _op.and(_t_Antiguedad.muy_antiguo.isEqual(Antiguedad),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Antiguedad.set(_i_Valoracion_Antiguedad,_rl, _t_Valoracion_Antiguedad.muy_mala); _i_Valoracion_Antiguedad++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = Valoracion_Antiguedad;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_Inferencia_Altura  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_Inferencia_Altura(MembershipFunction Altura, MembershipFunction Perfil) {
  double _rl;
  double _input[] = new double[2];
  if(Altura instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) Altura).getValue();
  if(Perfil instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) Perfil).getValue();
  OP__default_ _op = new OP__default_();
  OutputMembershipFunction Valoracion_Altura = new OutputMembershipFunction();
  Valoracion_Altura.set(40,_op,_input);
  TP_Numero _t_Altura = new TP_Numero();
  TP_Perfil _t_Perfil = new TP_Perfil();
  TP_Valoracion _t_Valoracion_Altura = new TP_Valoracion();
  int _i_Valoracion_Altura=0;
  _rl = _op.and(_t_Altura.uno.isEqual(Altura),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.muy_mala); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.uno.isEqual(Altura),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.mala); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.uno.isEqual(Altura),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.muy_mala); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.uno.isEqual(Altura),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.muy_mala); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.dos.isEqual(Altura),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.mala); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.dos.isEqual(Altura),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.regular); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.dos.isEqual(Altura),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.mala); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.dos.isEqual(Altura),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.mala); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.tres.isEqual(Altura),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.regular); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.tres.isEqual(Altura),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.muy_buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.tres.isEqual(Altura),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.regular); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.tres.isEqual(Altura),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.mala); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.cuatro.isEqual(Altura),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.cuatro.isEqual(Altura),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.muy_buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.cuatro.isEqual(Altura),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.cuatro.isEqual(Altura),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.regular); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.cinco.isEqual(Altura),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.cinco.isEqual(Altura),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.muy_buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.cinco.isEqual(Altura),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.cinco.isEqual(Altura),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.seis.isEqual(Altura),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.seis.isEqual(Altura),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.seis.isEqual(Altura),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.seis.isEqual(Altura),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.siete.isEqual(Altura),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.siete.isEqual(Altura),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.siete.isEqual(Altura),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.siete.isEqual(Altura),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.ocho.isEqual(Altura),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.ocho.isEqual(Altura),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.ocho.isEqual(Altura),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.ocho.isEqual(Altura),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.nueve.isEqual(Altura),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.muy_buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.nueve.isEqual(Altura),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.nueve.isEqual(Altura),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.muy_buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.nueve.isEqual(Altura),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.muy_buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.diez.isEqual(Altura),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.muy_buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.diez.isEqual(Altura),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.muy_buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.diez.isEqual(Altura),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.muy_buena); _i_Valoracion_Altura++;
  _rl = _op.and(_t_Altura.diez.isEqual(Altura),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Altura.set(_i_Valoracion_Altura,_rl, _t_Valoracion_Altura.muy_buena); _i_Valoracion_Altura++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = Valoracion_Altura;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_Inferencia_Ascensor  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_Inferencia_Ascensor(MembershipFunction Ascensor, MembershipFunction Perfil) {
  double _rl;
  double _input[] = new double[2];
  if(Ascensor instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) Ascensor).getValue();
  if(Perfil instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) Perfil).getValue();
  OP__default_ _op = new OP__default_();
  OutputMembershipFunction Valoracion_Ascensor = new OutputMembershipFunction();
  Valoracion_Ascensor.set(8,_op,_input);
  TP_Booleano _t_Ascensor = new TP_Booleano();
  TP_Perfil _t_Perfil = new TP_Perfil();
  TP_Valoracion _t_Valoracion_Ascensor = new TP_Valoracion();
  int _i_Valoracion_Ascensor=0;
  _rl = _op.and(_t_Ascensor.Si.isEqual(Ascensor),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Ascensor.set(_i_Valoracion_Ascensor,_rl, _t_Valoracion_Ascensor.regular); _i_Valoracion_Ascensor++;
  _rl = _op.and(_t_Ascensor.Si.isEqual(Ascensor),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Ascensor.set(_i_Valoracion_Ascensor,_rl, _t_Valoracion_Ascensor.regular); _i_Valoracion_Ascensor++;
  _rl = _op.and(_t_Ascensor.Si.isEqual(Ascensor),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Ascensor.set(_i_Valoracion_Ascensor,_rl, _t_Valoracion_Ascensor.mala); _i_Valoracion_Ascensor++;
  _rl = _op.and(_t_Ascensor.Si.isEqual(Ascensor),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Ascensor.set(_i_Valoracion_Ascensor,_rl, _t_Valoracion_Ascensor.buena); _i_Valoracion_Ascensor++;
  _rl = _op.and(_t_Ascensor.No.isEqual(Ascensor),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Ascensor.set(_i_Valoracion_Ascensor,_rl, _t_Valoracion_Ascensor.buena); _i_Valoracion_Ascensor++;
  _rl = _op.and(_t_Ascensor.No.isEqual(Ascensor),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Ascensor.set(_i_Valoracion_Ascensor,_rl, _t_Valoracion_Ascensor.buena); _i_Valoracion_Ascensor++;
  _rl = _op.and(_t_Ascensor.No.isEqual(Ascensor),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Ascensor.set(_i_Valoracion_Ascensor,_rl, _t_Valoracion_Ascensor.muy_buena); _i_Valoracion_Ascensor++;
  _rl = _op.and(_t_Ascensor.No.isEqual(Ascensor),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Ascensor.set(_i_Valoracion_Ascensor,_rl, _t_Valoracion_Ascensor.regular); _i_Valoracion_Ascensor++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = Valoracion_Ascensor;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_Inferencia_Garaje  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_Inferencia_Garaje(MembershipFunction Numero_Plazas, MembershipFunction Perfil) {
  double _rl;
  double _input[] = new double[2];
  if(Numero_Plazas instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) Numero_Plazas).getValue();
  if(Perfil instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) Perfil).getValue();
  OP__default_ _op = new OP__default_();
  OutputMembershipFunction Valoracion_Garaje = new OutputMembershipFunction();
  Valoracion_Garaje.set(2,_op,_input);
  TP_Numero _t_Numero_Plazas = new TP_Numero();
  TP_Perfil _t_Perfil = new TP_Perfil();
  TP_Valoracion _t_Valoracion_Garaje = new TP_Valoracion();
  int _i_Valoracion_Garaje=0;
  _rl = _op.and(_t_Numero_Plazas.uno.isEqual(Numero_Plazas),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Garaje.set(_i_Valoracion_Garaje,_rl, _t_Valoracion_Garaje.regular); _i_Valoracion_Garaje++;
  _rl = _op.and(_t_Numero_Plazas.dos.isEqual(Numero_Plazas),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Garaje.set(_i_Valoracion_Garaje,_rl, _t_Valoracion_Garaje.mala); _i_Valoracion_Garaje++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = Valoracion_Garaje;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_Inferencia_Estado_general  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_Inferencia_Estado_general(MembershipFunction Estado_general, MembershipFunction Perfil) {
  double _rl;
  double _input[] = new double[2];
  if(Estado_general instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) Estado_general).getValue();
  if(Perfil instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) Perfil).getValue();
  OP__default_ _op = new OP__default_();
  OutputMembershipFunction Valoracion_Estado_general = new OutputMembershipFunction();
  Valoracion_Estado_general.set(20,_op,_input);
  TP_Valoracion _t_Estado_general = new TP_Valoracion();
  TP_Perfil _t_Perfil = new TP_Perfil();
  TP_Valoracion _t_Valoracion_Estado_general = new TP_Valoracion();
  int _i_Valoracion_Estado_general=0;
  _rl = _op.and(_t_Estado_general.muy_mala.isEqual(Estado_general),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Estado_general.set(_i_Valoracion_Estado_general,_rl, _t_Valoracion_Estado_general.muy_mala); _i_Valoracion_Estado_general++;
  _rl = _op.and(_t_Estado_general.muy_mala.isEqual(Estado_general),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Estado_general.set(_i_Valoracion_Estado_general,_rl, _t_Valoracion_Estado_general.mala); _i_Valoracion_Estado_general++;
  _rl = _op.and(_t_Estado_general.muy_mala.isEqual(Estado_general),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Estado_general.set(_i_Valoracion_Estado_general,_rl, _t_Valoracion_Estado_general.muy_mala); _i_Valoracion_Estado_general++;
  _rl = _op.and(_t_Estado_general.muy_mala.isEqual(Estado_general),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Estado_general.set(_i_Valoracion_Estado_general,_rl, _t_Valoracion_Estado_general.mala); _i_Valoracion_Estado_general++;
  _rl = _op.and(_t_Estado_general.mala.isEqual(Estado_general),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Estado_general.set(_i_Valoracion_Estado_general,_rl, _t_Valoracion_Estado_general.mala); _i_Valoracion_Estado_general++;
  _rl = _op.and(_t_Estado_general.mala.isEqual(Estado_general),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Estado_general.set(_i_Valoracion_Estado_general,_rl, _t_Valoracion_Estado_general.regular); _i_Valoracion_Estado_general++;
  _rl = _op.and(_t_Estado_general.mala.isEqual(Estado_general),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Estado_general.set(_i_Valoracion_Estado_general,_rl, _t_Valoracion_Estado_general.mala); _i_Valoracion_Estado_general++;
  _rl = _op.and(_t_Estado_general.mala.isEqual(Estado_general),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Estado_general.set(_i_Valoracion_Estado_general,_rl, _t_Valoracion_Estado_general.regular); _i_Valoracion_Estado_general++;
  _rl = _op.and(_t_Estado_general.regular.isEqual(Estado_general),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Estado_general.set(_i_Valoracion_Estado_general,_rl, _t_Valoracion_Estado_general.regular); _i_Valoracion_Estado_general++;
  _rl = _op.and(_t_Estado_general.regular.isEqual(Estado_general),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Estado_general.set(_i_Valoracion_Estado_general,_rl, _t_Valoracion_Estado_general.regular); _i_Valoracion_Estado_general++;
  _rl = _op.and(_t_Estado_general.regular.isEqual(Estado_general),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Estado_general.set(_i_Valoracion_Estado_general,_rl, _t_Valoracion_Estado_general.regular); _i_Valoracion_Estado_general++;
  _rl = _op.and(_t_Estado_general.regular.isEqual(Estado_general),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Estado_general.set(_i_Valoracion_Estado_general,_rl, _t_Valoracion_Estado_general.regular); _i_Valoracion_Estado_general++;
  _rl = _op.and(_t_Estado_general.buena.isEqual(Estado_general),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Estado_general.set(_i_Valoracion_Estado_general,_rl, _t_Valoracion_Estado_general.buena); _i_Valoracion_Estado_general++;
  _rl = _op.and(_t_Estado_general.buena.isEqual(Estado_general),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Estado_general.set(_i_Valoracion_Estado_general,_rl, _t_Valoracion_Estado_general.buena); _i_Valoracion_Estado_general++;
  _rl = _op.and(_t_Estado_general.buena.isEqual(Estado_general),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Estado_general.set(_i_Valoracion_Estado_general,_rl, _t_Valoracion_Estado_general.buena); _i_Valoracion_Estado_general++;
  _rl = _op.and(_t_Estado_general.buena.isEqual(Estado_general),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Estado_general.set(_i_Valoracion_Estado_general,_rl, _t_Valoracion_Estado_general.buena); _i_Valoracion_Estado_general++;
  _rl = _op.and(_t_Estado_general.muy_buena.isEqual(Estado_general),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Estado_general.set(_i_Valoracion_Estado_general,_rl, _t_Valoracion_Estado_general.muy_buena); _i_Valoracion_Estado_general++;
  _rl = _op.and(_t_Estado_general.muy_buena.isEqual(Estado_general),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Estado_general.set(_i_Valoracion_Estado_general,_rl, _t_Valoracion_Estado_general.buena); _i_Valoracion_Estado_general++;
  _rl = _op.and(_t_Estado_general.muy_buena.isEqual(Estado_general),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Estado_general.set(_i_Valoracion_Estado_general,_rl, _t_Valoracion_Estado_general.muy_buena); _i_Valoracion_Estado_general++;
  _rl = _op.and(_t_Estado_general.muy_buena.isEqual(Estado_general),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Estado_general.set(_i_Valoracion_Estado_general,_rl, _t_Valoracion_Estado_general.buena); _i_Valoracion_Estado_general++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = Valoracion_Estado_general;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_Inferencia_Zonas_comunes  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_Inferencia_Zonas_comunes(MembershipFunction Zonas_comunes, MembershipFunction Perfil) {
  double _rl;
  double _input[] = new double[2];
  if(Zonas_comunes instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) Zonas_comunes).getValue();
  if(Perfil instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) Perfil).getValue();
  OP__default_ _op = new OP__default_();
  OutputMembershipFunction Valoracion_Zonas_comunes = new OutputMembershipFunction();
  Valoracion_Zonas_comunes.set(20,_op,_input);
  TP_Valoracion _t_Zonas_comunes = new TP_Valoracion();
  TP_Perfil _t_Perfil = new TP_Perfil();
  TP_Valoracion _t_Valoracion_Zonas_comunes = new TP_Valoracion();
  int _i_Valoracion_Zonas_comunes=0;
  _rl = _op.and(_t_Zonas_comunes.muy_mala.isEqual(Zonas_comunes),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Zonas_comunes.set(_i_Valoracion_Zonas_comunes,_rl, _t_Valoracion_Zonas_comunes.muy_mala); _i_Valoracion_Zonas_comunes++;
  _rl = _op.and(_t_Zonas_comunes.muy_mala.isEqual(Zonas_comunes),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Zonas_comunes.set(_i_Valoracion_Zonas_comunes,_rl, _t_Valoracion_Zonas_comunes.mala); _i_Valoracion_Zonas_comunes++;
  _rl = _op.and(_t_Zonas_comunes.muy_mala.isEqual(Zonas_comunes),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Zonas_comunes.set(_i_Valoracion_Zonas_comunes,_rl, _t_Valoracion_Zonas_comunes.muy_mala); _i_Valoracion_Zonas_comunes++;
  _rl = _op.and(_t_Zonas_comunes.muy_mala.isEqual(Zonas_comunes),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Zonas_comunes.set(_i_Valoracion_Zonas_comunes,_rl, _t_Valoracion_Zonas_comunes.mala); _i_Valoracion_Zonas_comunes++;
  _rl = _op.and(_t_Zonas_comunes.mala.isEqual(Zonas_comunes),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Zonas_comunes.set(_i_Valoracion_Zonas_comunes,_rl, _t_Valoracion_Zonas_comunes.mala); _i_Valoracion_Zonas_comunes++;
  _rl = _op.and(_t_Zonas_comunes.mala.isEqual(Zonas_comunes),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Zonas_comunes.set(_i_Valoracion_Zonas_comunes,_rl, _t_Valoracion_Zonas_comunes.regular); _i_Valoracion_Zonas_comunes++;
  _rl = _op.and(_t_Zonas_comunes.mala.isEqual(Zonas_comunes),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Zonas_comunes.set(_i_Valoracion_Zonas_comunes,_rl, _t_Valoracion_Zonas_comunes.mala); _i_Valoracion_Zonas_comunes++;
  _rl = _op.and(_t_Zonas_comunes.mala.isEqual(Zonas_comunes),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Zonas_comunes.set(_i_Valoracion_Zonas_comunes,_rl, _t_Valoracion_Zonas_comunes.regular); _i_Valoracion_Zonas_comunes++;
  _rl = _op.and(_t_Zonas_comunes.regular.isEqual(Zonas_comunes),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Zonas_comunes.set(_i_Valoracion_Zonas_comunes,_rl, _t_Valoracion_Zonas_comunes.regular); _i_Valoracion_Zonas_comunes++;
  _rl = _op.and(_t_Zonas_comunes.regular.isEqual(Zonas_comunes),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Zonas_comunes.set(_i_Valoracion_Zonas_comunes,_rl, _t_Valoracion_Zonas_comunes.regular); _i_Valoracion_Zonas_comunes++;
  _rl = _op.and(_t_Zonas_comunes.regular.isEqual(Zonas_comunes),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Zonas_comunes.set(_i_Valoracion_Zonas_comunes,_rl, _t_Valoracion_Zonas_comunes.regular); _i_Valoracion_Zonas_comunes++;
  _rl = _op.and(_t_Zonas_comunes.regular.isEqual(Zonas_comunes),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Zonas_comunes.set(_i_Valoracion_Zonas_comunes,_rl, _t_Valoracion_Zonas_comunes.regular); _i_Valoracion_Zonas_comunes++;
  _rl = _op.and(_t_Zonas_comunes.buena.isEqual(Zonas_comunes),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Zonas_comunes.set(_i_Valoracion_Zonas_comunes,_rl, _t_Valoracion_Zonas_comunes.buena); _i_Valoracion_Zonas_comunes++;
  _rl = _op.and(_t_Zonas_comunes.buena.isEqual(Zonas_comunes),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Zonas_comunes.set(_i_Valoracion_Zonas_comunes,_rl, _t_Valoracion_Zonas_comunes.buena); _i_Valoracion_Zonas_comunes++;
  _rl = _op.and(_t_Zonas_comunes.buena.isEqual(Zonas_comunes),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Zonas_comunes.set(_i_Valoracion_Zonas_comunes,_rl, _t_Valoracion_Zonas_comunes.buena); _i_Valoracion_Zonas_comunes++;
  _rl = _op.and(_t_Zonas_comunes.buena.isEqual(Zonas_comunes),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Zonas_comunes.set(_i_Valoracion_Zonas_comunes,_rl, _t_Valoracion_Zonas_comunes.buena); _i_Valoracion_Zonas_comunes++;
  _rl = _op.and(_t_Zonas_comunes.muy_buena.isEqual(Zonas_comunes),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Zonas_comunes.set(_i_Valoracion_Zonas_comunes,_rl, _t_Valoracion_Zonas_comunes.muy_buena); _i_Valoracion_Zonas_comunes++;
  _rl = _op.and(_t_Zonas_comunes.muy_buena.isEqual(Zonas_comunes),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Zonas_comunes.set(_i_Valoracion_Zonas_comunes,_rl, _t_Valoracion_Zonas_comunes.buena); _i_Valoracion_Zonas_comunes++;
  _rl = _op.and(_t_Zonas_comunes.muy_buena.isEqual(Zonas_comunes),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Zonas_comunes.set(_i_Valoracion_Zonas_comunes,_rl, _t_Valoracion_Zonas_comunes.muy_buena); _i_Valoracion_Zonas_comunes++;
  _rl = _op.and(_t_Zonas_comunes.muy_buena.isEqual(Zonas_comunes),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Zonas_comunes.set(_i_Valoracion_Zonas_comunes,_rl, _t_Valoracion_Zonas_comunes.buena); _i_Valoracion_Zonas_comunes++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = Valoracion_Zonas_comunes;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_Inferencia_Zona_subzona  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_Inferencia_Zona_subzona(MembershipFunction Zona_subzona, MembershipFunction Perfil) {
  double _rl;
  double _input[] = new double[2];
  if(Zona_subzona instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) Zona_subzona).getValue();
  if(Perfil instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) Perfil).getValue();
  OP__default_ _op = new OP__default_();
  OutputMembershipFunction Valoracion_Zona_subzona = new OutputMembershipFunction();
  Valoracion_Zona_subzona.set(20,_op,_input);
  TP_Valoracion _t_Zona_subzona = new TP_Valoracion();
  TP_Perfil _t_Perfil = new TP_Perfil();
  TP_Valoracion _t_Valoracion_Zona_subzona = new TP_Valoracion();
  int _i_Valoracion_Zona_subzona=0;
  _rl = _op.and(_t_Zona_subzona.muy_mala.isEqual(Zona_subzona),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Zona_subzona.set(_i_Valoracion_Zona_subzona,_rl, _t_Valoracion_Zona_subzona.muy_mala); _i_Valoracion_Zona_subzona++;
  _rl = _op.and(_t_Zona_subzona.muy_mala.isEqual(Zona_subzona),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Zona_subzona.set(_i_Valoracion_Zona_subzona,_rl, _t_Valoracion_Zona_subzona.mala); _i_Valoracion_Zona_subzona++;
  _rl = _op.and(_t_Zona_subzona.muy_mala.isEqual(Zona_subzona),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Zona_subzona.set(_i_Valoracion_Zona_subzona,_rl, _t_Valoracion_Zona_subzona.muy_mala); _i_Valoracion_Zona_subzona++;
  _rl = _op.and(_t_Zona_subzona.muy_mala.isEqual(Zona_subzona),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Zona_subzona.set(_i_Valoracion_Zona_subzona,_rl, _t_Valoracion_Zona_subzona.mala); _i_Valoracion_Zona_subzona++;
  _rl = _op.and(_t_Zona_subzona.mala.isEqual(Zona_subzona),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Zona_subzona.set(_i_Valoracion_Zona_subzona,_rl, _t_Valoracion_Zona_subzona.mala); _i_Valoracion_Zona_subzona++;
  _rl = _op.and(_t_Zona_subzona.mala.isEqual(Zona_subzona),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Zona_subzona.set(_i_Valoracion_Zona_subzona,_rl, _t_Valoracion_Zona_subzona.regular); _i_Valoracion_Zona_subzona++;
  _rl = _op.and(_t_Zona_subzona.mala.isEqual(Zona_subzona),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Zona_subzona.set(_i_Valoracion_Zona_subzona,_rl, _t_Valoracion_Zona_subzona.mala); _i_Valoracion_Zona_subzona++;
  _rl = _op.and(_t_Zona_subzona.mala.isEqual(Zona_subzona),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Zona_subzona.set(_i_Valoracion_Zona_subzona,_rl, _t_Valoracion_Zona_subzona.regular); _i_Valoracion_Zona_subzona++;
  _rl = _op.and(_t_Zona_subzona.regular.isEqual(Zona_subzona),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Zona_subzona.set(_i_Valoracion_Zona_subzona,_rl, _t_Valoracion_Zona_subzona.regular); _i_Valoracion_Zona_subzona++;
  _rl = _op.and(_t_Zona_subzona.regular.isEqual(Zona_subzona),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Zona_subzona.set(_i_Valoracion_Zona_subzona,_rl, _t_Valoracion_Zona_subzona.regular); _i_Valoracion_Zona_subzona++;
  _rl = _op.and(_t_Zona_subzona.regular.isEqual(Zona_subzona),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Zona_subzona.set(_i_Valoracion_Zona_subzona,_rl, _t_Valoracion_Zona_subzona.regular); _i_Valoracion_Zona_subzona++;
  _rl = _op.and(_t_Zona_subzona.regular.isEqual(Zona_subzona),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Zona_subzona.set(_i_Valoracion_Zona_subzona,_rl, _t_Valoracion_Zona_subzona.regular); _i_Valoracion_Zona_subzona++;
  _rl = _op.and(_t_Zona_subzona.buena.isEqual(Zona_subzona),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Zona_subzona.set(_i_Valoracion_Zona_subzona,_rl, _t_Valoracion_Zona_subzona.buena); _i_Valoracion_Zona_subzona++;
  _rl = _op.and(_t_Zona_subzona.buena.isEqual(Zona_subzona),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Zona_subzona.set(_i_Valoracion_Zona_subzona,_rl, _t_Valoracion_Zona_subzona.buena); _i_Valoracion_Zona_subzona++;
  _rl = _op.and(_t_Zona_subzona.buena.isEqual(Zona_subzona),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Zona_subzona.set(_i_Valoracion_Zona_subzona,_rl, _t_Valoracion_Zona_subzona.buena); _i_Valoracion_Zona_subzona++;
  _rl = _op.and(_t_Zona_subzona.buena.isEqual(Zona_subzona),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Zona_subzona.set(_i_Valoracion_Zona_subzona,_rl, _t_Valoracion_Zona_subzona.buena); _i_Valoracion_Zona_subzona++;
  _rl = _op.and(_t_Zona_subzona.muy_buena.isEqual(Zona_subzona),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Zona_subzona.set(_i_Valoracion_Zona_subzona,_rl, _t_Valoracion_Zona_subzona.muy_buena); _i_Valoracion_Zona_subzona++;
  _rl = _op.and(_t_Zona_subzona.muy_buena.isEqual(Zona_subzona),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Zona_subzona.set(_i_Valoracion_Zona_subzona,_rl, _t_Valoracion_Zona_subzona.buena); _i_Valoracion_Zona_subzona++;
  _rl = _op.and(_t_Zona_subzona.muy_buena.isEqual(Zona_subzona),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Zona_subzona.set(_i_Valoracion_Zona_subzona,_rl, _t_Valoracion_Zona_subzona.muy_buena); _i_Valoracion_Zona_subzona++;
  _rl = _op.and(_t_Zona_subzona.muy_buena.isEqual(Zona_subzona),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Zona_subzona.set(_i_Valoracion_Zona_subzona,_rl, _t_Valoracion_Zona_subzona.buena); _i_Valoracion_Zona_subzona++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = Valoracion_Zona_subzona;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_Inferencia_Metros_construidos  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_Inferencia_Metros_construidos(MembershipFunction Metros_construidos, MembershipFunction Perfil) {
  double _rl;
  double _input[] = new double[2];
  if(Metros_construidos instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) Metros_construidos).getValue();
  if(Perfil instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) Perfil).getValue();
  OP__default_ _op = new OP__default_();
  OutputMembershipFunction Valoracion_Metros_construidos = new OutputMembershipFunction();
  Valoracion_Metros_construidos.set(16,_op,_input);
  TP_Metros _t_Metros_construidos = new TP_Metros();
  TP_Perfil _t_Perfil = new TP_Perfil();
  TP_Valoracion _t_Valoracion_Metros_construidos = new TP_Valoracion();
  int _i_Valoracion_Metros_construidos=0;
  _rl = _op.and(_t_Metros_construidos.muy_pocos.isEqual(Metros_construidos),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Metros_construidos.set(_i_Valoracion_Metros_construidos,_rl, _t_Valoracion_Metros_construidos.mala); _i_Valoracion_Metros_construidos++;
  _rl = _op.and(_t_Metros_construidos.muy_pocos.isEqual(Metros_construidos),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Metros_construidos.set(_i_Valoracion_Metros_construidos,_rl, _t_Valoracion_Metros_construidos.muy_mala); _i_Valoracion_Metros_construidos++;
  _rl = _op.and(_t_Metros_construidos.muy_pocos.isEqual(Metros_construidos),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Metros_construidos.set(_i_Valoracion_Metros_construidos,_rl, _t_Valoracion_Metros_construidos.muy_mala); _i_Valoracion_Metros_construidos++;
  _rl = _op.and(_t_Metros_construidos.muy_pocos.isEqual(Metros_construidos),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Metros_construidos.set(_i_Valoracion_Metros_construidos,_rl, _t_Valoracion_Metros_construidos.mala); _i_Valoracion_Metros_construidos++;
  _rl = _op.and(_t_Metros_construidos.pocos.isEqual(Metros_construidos),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Metros_construidos.set(_i_Valoracion_Metros_construidos,_rl, _t_Valoracion_Metros_construidos.regular); _i_Valoracion_Metros_construidos++;
  _rl = _op.and(_t_Metros_construidos.pocos.isEqual(Metros_construidos),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Metros_construidos.set(_i_Valoracion_Metros_construidos,_rl, _t_Valoracion_Metros_construidos.mala); _i_Valoracion_Metros_construidos++;
  _rl = _op.and(_t_Metros_construidos.pocos.isEqual(Metros_construidos),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Metros_construidos.set(_i_Valoracion_Metros_construidos,_rl, _t_Valoracion_Metros_construidos.mala); _i_Valoracion_Metros_construidos++;
  _rl = _op.and(_t_Metros_construidos.pocos.isEqual(Metros_construidos),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Metros_construidos.set(_i_Valoracion_Metros_construidos,_rl, _t_Valoracion_Metros_construidos.regular); _i_Valoracion_Metros_construidos++;
  _rl = _op.and(_t_Metros_construidos.normal.isEqual(Metros_construidos),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Metros_construidos.set(_i_Valoracion_Metros_construidos,_rl, _t_Valoracion_Metros_construidos.buena); _i_Valoracion_Metros_construidos++;
  _rl = _op.and(_t_Metros_construidos.normal.isEqual(Metros_construidos),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Metros_construidos.set(_i_Valoracion_Metros_construidos,_rl, _t_Valoracion_Metros_construidos.buena); _i_Valoracion_Metros_construidos++;
  _rl = _op.and(_t_Metros_construidos.normal.isEqual(Metros_construidos),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Metros_construidos.set(_i_Valoracion_Metros_construidos,_rl, _t_Valoracion_Metros_construidos.buena); _i_Valoracion_Metros_construidos++;
  _rl = _op.and(_t_Metros_construidos.normal.isEqual(Metros_construidos),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Metros_construidos.set(_i_Valoracion_Metros_construidos,_rl, _t_Valoracion_Metros_construidos.buena); _i_Valoracion_Metros_construidos++;
  _rl = _op.and(_t_Metros_construidos.bastantes.isEqual(Metros_construidos),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Metros_construidos.set(_i_Valoracion_Metros_construidos,_rl, _t_Valoracion_Metros_construidos.muy_buena); _i_Valoracion_Metros_construidos++;
  _rl = _op.and(_t_Metros_construidos.bastantes.isEqual(Metros_construidos),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Metros_construidos.set(_i_Valoracion_Metros_construidos,_rl, _t_Valoracion_Metros_construidos.muy_buena); _i_Valoracion_Metros_construidos++;
  _rl = _op.and(_t_Metros_construidos.bastantes.isEqual(Metros_construidos),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Metros_construidos.set(_i_Valoracion_Metros_construidos,_rl, _t_Valoracion_Metros_construidos.buena); _i_Valoracion_Metros_construidos++;
  _rl = _op.and(_t_Metros_construidos.bastantes.isEqual(Metros_construidos),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Metros_construidos.set(_i_Valoracion_Metros_construidos,_rl, _t_Valoracion_Metros_construidos.buena); _i_Valoracion_Metros_construidos++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = Valoracion_Metros_construidos;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_Inferencia_Metros_habitables  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_Inferencia_Metros_habitables(MembershipFunction Metros_habitables, MembershipFunction Perfil) {
  double _rl;
  double _input[] = new double[2];
  if(Metros_habitables instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) Metros_habitables).getValue();
  if(Perfil instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) Perfil).getValue();
  OP__default_ _op = new OP__default_();
  OutputMembershipFunction Valoracion_Metros_habitables = new OutputMembershipFunction();
  Valoracion_Metros_habitables.set(16,_op,_input);
  TP_Metros _t_Metros_habitables = new TP_Metros();
  TP_Perfil _t_Perfil = new TP_Perfil();
  TP_Valoracion _t_Valoracion_Metros_habitables = new TP_Valoracion();
  int _i_Valoracion_Metros_habitables=0;
  _rl = _op.and(_t_Metros_habitables.muy_pocos.isEqual(Metros_habitables),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Metros_habitables.set(_i_Valoracion_Metros_habitables,_rl, _t_Valoracion_Metros_habitables.muy_mala); _i_Valoracion_Metros_habitables++;
  _rl = _op.and(_t_Metros_habitables.muy_pocos.isEqual(Metros_habitables),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Metros_habitables.set(_i_Valoracion_Metros_habitables,_rl, _t_Valoracion_Metros_habitables.muy_mala); _i_Valoracion_Metros_habitables++;
  _rl = _op.and(_t_Metros_habitables.muy_pocos.isEqual(Metros_habitables),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Metros_habitables.set(_i_Valoracion_Metros_habitables,_rl, _t_Valoracion_Metros_habitables.mala); _i_Valoracion_Metros_habitables++;
  _rl = _op.and(_t_Metros_habitables.muy_pocos.isEqual(Metros_habitables),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Metros_habitables.set(_i_Valoracion_Metros_habitables,_rl, _t_Valoracion_Metros_habitables.mala); _i_Valoracion_Metros_habitables++;
  _rl = _op.and(_t_Metros_habitables.pocos.isEqual(Metros_habitables),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Metros_habitables.set(_i_Valoracion_Metros_habitables,_rl, _t_Valoracion_Metros_habitables.mala); _i_Valoracion_Metros_habitables++;
  _rl = _op.and(_t_Metros_habitables.pocos.isEqual(Metros_habitables),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Metros_habitables.set(_i_Valoracion_Metros_habitables,_rl, _t_Valoracion_Metros_habitables.mala); _i_Valoracion_Metros_habitables++;
  _rl = _op.and(_t_Metros_habitables.pocos.isEqual(Metros_habitables),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Metros_habitables.set(_i_Valoracion_Metros_habitables,_rl, _t_Valoracion_Metros_habitables.regular); _i_Valoracion_Metros_habitables++;
  _rl = _op.and(_t_Metros_habitables.pocos.isEqual(Metros_habitables),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Metros_habitables.set(_i_Valoracion_Metros_habitables,_rl, _t_Valoracion_Metros_habitables.regular); _i_Valoracion_Metros_habitables++;
  _rl = _op.and(_t_Metros_habitables.normal.isEqual(Metros_habitables),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Metros_habitables.set(_i_Valoracion_Metros_habitables,_rl, _t_Valoracion_Metros_habitables.regular); _i_Valoracion_Metros_habitables++;
  _rl = _op.and(_t_Metros_habitables.normal.isEqual(Metros_habitables),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Metros_habitables.set(_i_Valoracion_Metros_habitables,_rl, _t_Valoracion_Metros_habitables.regular); _i_Valoracion_Metros_habitables++;
  _rl = _op.and(_t_Metros_habitables.normal.isEqual(Metros_habitables),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Metros_habitables.set(_i_Valoracion_Metros_habitables,_rl, _t_Valoracion_Metros_habitables.buena); _i_Valoracion_Metros_habitables++;
  _rl = _op.and(_t_Metros_habitables.normal.isEqual(Metros_habitables),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Metros_habitables.set(_i_Valoracion_Metros_habitables,_rl, _t_Valoracion_Metros_habitables.regular); _i_Valoracion_Metros_habitables++;
  _rl = _op.and(_t_Metros_habitables.bastantes.isEqual(Metros_habitables),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Metros_habitables.set(_i_Valoracion_Metros_habitables,_rl, _t_Valoracion_Metros_habitables.buena); _i_Valoracion_Metros_habitables++;
  _rl = _op.and(_t_Metros_habitables.bastantes.isEqual(Metros_habitables),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Metros_habitables.set(_i_Valoracion_Metros_habitables,_rl, _t_Valoracion_Metros_habitables.muy_buena); _i_Valoracion_Metros_habitables++;
  _rl = _op.and(_t_Metros_habitables.bastantes.isEqual(Metros_habitables),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Metros_habitables.set(_i_Valoracion_Metros_habitables,_rl, _t_Valoracion_Metros_habitables.buena); _i_Valoracion_Metros_habitables++;
  _rl = _op.and(_t_Metros_habitables.bastantes.isEqual(Metros_habitables),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Metros_habitables.set(_i_Valoracion_Metros_habitables,_rl, _t_Valoracion_Metros_habitables.buena); _i_Valoracion_Metros_habitables++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = Valoracion_Metros_habitables;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_Inferencia_Precio_tasacion  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_Inferencia_Precio_tasacion(MembershipFunction Precio_tasacion, MembershipFunction Perfil) {
  double _rl;
  double _input[] = new double[2];
  if(Precio_tasacion instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) Precio_tasacion).getValue();
  if(Perfil instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) Perfil).getValue();
  OP__default_ _op = new OP__default_();
  OutputMembershipFunction Valoracion_Precio_tasacion = new OutputMembershipFunction();
  Valoracion_Precio_tasacion.set(20,_op,_input);
  TP_Precio _t_Precio_tasacion = new TP_Precio();
  TP_Perfil _t_Perfil = new TP_Perfil();
  TP_Valoracion _t_Valoracion_Precio_tasacion = new TP_Valoracion();
  int _i_Valoracion_Precio_tasacion=0;
  _rl = _op.and(_t_Precio_tasacion.barato.isEqual(Precio_tasacion),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Precio_tasacion.set(_i_Valoracion_Precio_tasacion,_rl, _t_Valoracion_Precio_tasacion.muy_buena); _i_Valoracion_Precio_tasacion++;
  _rl = _op.and(_t_Precio_tasacion.barato.isEqual(Precio_tasacion),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Precio_tasacion.set(_i_Valoracion_Precio_tasacion,_rl, _t_Valoracion_Precio_tasacion.buena); _i_Valoracion_Precio_tasacion++;
  _rl = _op.and(_t_Precio_tasacion.barato.isEqual(Precio_tasacion),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Precio_tasacion.set(_i_Valoracion_Precio_tasacion,_rl, _t_Valoracion_Precio_tasacion.muy_buena); _i_Valoracion_Precio_tasacion++;
  _rl = _op.and(_t_Precio_tasacion.barato.isEqual(Precio_tasacion),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Precio_tasacion.set(_i_Valoracion_Precio_tasacion,_rl, _t_Valoracion_Precio_tasacion.muy_buena); _i_Valoracion_Precio_tasacion++;
  _rl = _op.and(_t_Precio_tasacion.poco_barato.isEqual(Precio_tasacion),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Precio_tasacion.set(_i_Valoracion_Precio_tasacion,_rl, _t_Valoracion_Precio_tasacion.muy_buena); _i_Valoracion_Precio_tasacion++;
  _rl = _op.and(_t_Precio_tasacion.poco_barato.isEqual(Precio_tasacion),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Precio_tasacion.set(_i_Valoracion_Precio_tasacion,_rl, _t_Valoracion_Precio_tasacion.regular); _i_Valoracion_Precio_tasacion++;
  _rl = _op.and(_t_Precio_tasacion.poco_barato.isEqual(Precio_tasacion),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Precio_tasacion.set(_i_Valoracion_Precio_tasacion,_rl, _t_Valoracion_Precio_tasacion.buena); _i_Valoracion_Precio_tasacion++;
  _rl = _op.and(_t_Precio_tasacion.poco_barato.isEqual(Precio_tasacion),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Precio_tasacion.set(_i_Valoracion_Precio_tasacion,_rl, _t_Valoracion_Precio_tasacion.buena); _i_Valoracion_Precio_tasacion++;
  _rl = _op.and(_t_Precio_tasacion.normal.isEqual(Precio_tasacion),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Precio_tasacion.set(_i_Valoracion_Precio_tasacion,_rl, _t_Valoracion_Precio_tasacion.buena); _i_Valoracion_Precio_tasacion++;
  _rl = _op.and(_t_Precio_tasacion.normal.isEqual(Precio_tasacion),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Precio_tasacion.set(_i_Valoracion_Precio_tasacion,_rl, _t_Valoracion_Precio_tasacion.buena); _i_Valoracion_Precio_tasacion++;
  _rl = _op.and(_t_Precio_tasacion.normal.isEqual(Precio_tasacion),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Precio_tasacion.set(_i_Valoracion_Precio_tasacion,_rl, _t_Valoracion_Precio_tasacion.regular); _i_Valoracion_Precio_tasacion++;
  _rl = _op.and(_t_Precio_tasacion.normal.isEqual(Precio_tasacion),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Precio_tasacion.set(_i_Valoracion_Precio_tasacion,_rl, _t_Valoracion_Precio_tasacion.regular); _i_Valoracion_Precio_tasacion++;
  _rl = _op.and(_t_Precio_tasacion.caro.isEqual(Precio_tasacion),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Precio_tasacion.set(_i_Valoracion_Precio_tasacion,_rl, _t_Valoracion_Precio_tasacion.mala); _i_Valoracion_Precio_tasacion++;
  _rl = _op.and(_t_Precio_tasacion.caro.isEqual(Precio_tasacion),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Precio_tasacion.set(_i_Valoracion_Precio_tasacion,_rl, _t_Valoracion_Precio_tasacion.mala); _i_Valoracion_Precio_tasacion++;
  _rl = _op.and(_t_Precio_tasacion.caro.isEqual(Precio_tasacion),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Precio_tasacion.set(_i_Valoracion_Precio_tasacion,_rl, _t_Valoracion_Precio_tasacion.mala); _i_Valoracion_Precio_tasacion++;
  _rl = _op.and(_t_Precio_tasacion.caro.isEqual(Precio_tasacion),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Precio_tasacion.set(_i_Valoracion_Precio_tasacion,_rl, _t_Valoracion_Precio_tasacion.mala); _i_Valoracion_Precio_tasacion++;
  _rl = _op.and(_t_Precio_tasacion.muy_caro.isEqual(Precio_tasacion),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Precio_tasacion.set(_i_Valoracion_Precio_tasacion,_rl, _t_Valoracion_Precio_tasacion.muy_mala); _i_Valoracion_Precio_tasacion++;
  _rl = _op.and(_t_Precio_tasacion.muy_caro.isEqual(Precio_tasacion),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Precio_tasacion.set(_i_Valoracion_Precio_tasacion,_rl, _t_Valoracion_Precio_tasacion.muy_mala); _i_Valoracion_Precio_tasacion++;
  _rl = _op.and(_t_Precio_tasacion.muy_caro.isEqual(Precio_tasacion),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Precio_tasacion.set(_i_Valoracion_Precio_tasacion,_rl, _t_Valoracion_Precio_tasacion.muy_mala); _i_Valoracion_Precio_tasacion++;
  _rl = _op.and(_t_Precio_tasacion.muy_caro.isEqual(Precio_tasacion),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Precio_tasacion.set(_i_Valoracion_Precio_tasacion,_rl, _t_Valoracion_Precio_tasacion.muy_mala); _i_Valoracion_Precio_tasacion++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = Valoracion_Precio_tasacion;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_Inferencia_Precio_salida  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_Inferencia_Precio_salida(MembershipFunction Precio_salida, MembershipFunction Perfil) {
  double _rl;
  double _input[] = new double[2];
  if(Precio_salida instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) Precio_salida).getValue();
  if(Perfil instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) Perfil).getValue();
  OP__default_ _op = new OP__default_();
  OutputMembershipFunction Valoracion_Precio_salida = new OutputMembershipFunction();
  Valoracion_Precio_salida.set(20,_op,_input);
  TP_Precio _t_Precio_salida = new TP_Precio();
  TP_Perfil _t_Perfil = new TP_Perfil();
  TP_Valoracion _t_Valoracion_Precio_salida = new TP_Valoracion();
  int _i_Valoracion_Precio_salida=0;
  _rl = _op.and(_t_Precio_salida.barato.isEqual(Precio_salida),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Precio_salida.set(_i_Valoracion_Precio_salida,_rl, _t_Valoracion_Precio_salida.mala); _i_Valoracion_Precio_salida++;
  _rl = _op.and(_t_Precio_salida.barato.isEqual(Precio_salida),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Precio_salida.set(_i_Valoracion_Precio_salida,_rl, _t_Valoracion_Precio_salida.mala); _i_Valoracion_Precio_salida++;
  _rl = _op.and(_t_Precio_salida.barato.isEqual(Precio_salida),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Precio_salida.set(_i_Valoracion_Precio_salida,_rl, _t_Valoracion_Precio_salida.mala); _i_Valoracion_Precio_salida++;
  _rl = _op.and(_t_Precio_salida.barato.isEqual(Precio_salida),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Precio_salida.set(_i_Valoracion_Precio_salida,_rl, _t_Valoracion_Precio_salida.mala); _i_Valoracion_Precio_salida++;
  _rl = _op.and(_t_Precio_salida.poco_barato.isEqual(Precio_salida),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Precio_salida.set(_i_Valoracion_Precio_salida,_rl, _t_Valoracion_Precio_salida.regular); _i_Valoracion_Precio_salida++;
  _rl = _op.and(_t_Precio_salida.poco_barato.isEqual(Precio_salida),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Precio_salida.set(_i_Valoracion_Precio_salida,_rl, _t_Valoracion_Precio_salida.regular); _i_Valoracion_Precio_salida++;
  _rl = _op.and(_t_Precio_salida.poco_barato.isEqual(Precio_salida),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Precio_salida.set(_i_Valoracion_Precio_salida,_rl, _t_Valoracion_Precio_salida.regular); _i_Valoracion_Precio_salida++;
  _rl = _op.and(_t_Precio_salida.poco_barato.isEqual(Precio_salida),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Precio_salida.set(_i_Valoracion_Precio_salida,_rl, _t_Valoracion_Precio_salida.regular); _i_Valoracion_Precio_salida++;
  _rl = _op.and(_t_Precio_salida.normal.isEqual(Precio_salida),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Precio_salida.set(_i_Valoracion_Precio_salida,_rl, _t_Valoracion_Precio_salida.regular); _i_Valoracion_Precio_salida++;
  _rl = _op.and(_t_Precio_salida.normal.isEqual(Precio_salida),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Precio_salida.set(_i_Valoracion_Precio_salida,_rl, _t_Valoracion_Precio_salida.buena); _i_Valoracion_Precio_salida++;
  _rl = _op.and(_t_Precio_salida.normal.isEqual(Precio_salida),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Precio_salida.set(_i_Valoracion_Precio_salida,_rl, _t_Valoracion_Precio_salida.buena); _i_Valoracion_Precio_salida++;
  _rl = _op.and(_t_Precio_salida.normal.isEqual(Precio_salida),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Precio_salida.set(_i_Valoracion_Precio_salida,_rl, _t_Valoracion_Precio_salida.regular); _i_Valoracion_Precio_salida++;
  _rl = _op.and(_t_Precio_salida.caro.isEqual(Precio_salida),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Precio_salida.set(_i_Valoracion_Precio_salida,_rl, _t_Valoracion_Precio_salida.buena); _i_Valoracion_Precio_salida++;
  _rl = _op.and(_t_Precio_salida.caro.isEqual(Precio_salida),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Precio_salida.set(_i_Valoracion_Precio_salida,_rl, _t_Valoracion_Precio_salida.buena); _i_Valoracion_Precio_salida++;
  _rl = _op.and(_t_Precio_salida.caro.isEqual(Precio_salida),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Precio_salida.set(_i_Valoracion_Precio_salida,_rl, _t_Valoracion_Precio_salida.buena); _i_Valoracion_Precio_salida++;
  _rl = _op.and(_t_Precio_salida.caro.isEqual(Precio_salida),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Precio_salida.set(_i_Valoracion_Precio_salida,_rl, _t_Valoracion_Precio_salida.buena); _i_Valoracion_Precio_salida++;
  _rl = _op.and(_t_Precio_salida.muy_caro.isEqual(Precio_salida),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Precio_salida.set(_i_Valoracion_Precio_salida,_rl, _t_Valoracion_Precio_salida.muy_buena); _i_Valoracion_Precio_salida++;
  _rl = _op.and(_t_Precio_salida.muy_caro.isEqual(Precio_salida),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Precio_salida.set(_i_Valoracion_Precio_salida,_rl, _t_Valoracion_Precio_salida.buena); _i_Valoracion_Precio_salida++;
  _rl = _op.and(_t_Precio_salida.muy_caro.isEqual(Precio_salida),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Precio_salida.set(_i_Valoracion_Precio_salida,_rl, _t_Valoracion_Precio_salida.muy_buena); _i_Valoracion_Precio_salida++;
  _rl = _op.and(_t_Precio_salida.muy_caro.isEqual(Precio_salida),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Precio_salida.set(_i_Valoracion_Precio_salida,_rl, _t_Valoracion_Precio_salida.muy_buena); _i_Valoracion_Precio_salida++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = Valoracion_Precio_salida;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //  Rulebase RL_Inferencia_Precio_venta  //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 private MembershipFunction[] RL_Inferencia_Precio_venta(MembershipFunction Precio_venta, MembershipFunction Perfil) {
  double _rl;
  double _input[] = new double[2];
  if(Precio_venta instanceof FuzzySingleton)
   _input[0] = ((FuzzySingleton) Precio_venta).getValue();
  if(Perfil instanceof FuzzySingleton)
   _input[1] = ((FuzzySingleton) Perfil).getValue();
  OP__default_ _op = new OP__default_();
  OutputMembershipFunction Valoracion_Precio_venta = new OutputMembershipFunction();
  Valoracion_Precio_venta.set(20,_op,_input);
  TP_Precio _t_Precio_venta = new TP_Precio();
  TP_Perfil _t_Perfil = new TP_Perfil();
  TP_Valoracion _t_Valoracion_Precio_venta = new TP_Valoracion();
  int _i_Valoracion_Precio_venta=0;
  _rl = _op.and(_t_Precio_venta.barato.isEqual(Precio_venta),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Precio_venta.set(_i_Valoracion_Precio_venta,_rl, _t_Valoracion_Precio_venta.mala); _i_Valoracion_Precio_venta++;
  _rl = _op.and(_t_Precio_venta.barato.isEqual(Precio_venta),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Precio_venta.set(_i_Valoracion_Precio_venta,_rl, _t_Valoracion_Precio_venta.mala); _i_Valoracion_Precio_venta++;
  _rl = _op.and(_t_Precio_venta.barato.isEqual(Precio_venta),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Precio_venta.set(_i_Valoracion_Precio_venta,_rl, _t_Valoracion_Precio_venta.mala); _i_Valoracion_Precio_venta++;
  _rl = _op.and(_t_Precio_venta.barato.isEqual(Precio_venta),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Precio_venta.set(_i_Valoracion_Precio_venta,_rl, _t_Valoracion_Precio_venta.mala); _i_Valoracion_Precio_venta++;
  _rl = _op.and(_t_Precio_venta.poco_barato.isEqual(Precio_venta),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Precio_venta.set(_i_Valoracion_Precio_venta,_rl, _t_Valoracion_Precio_venta.regular); _i_Valoracion_Precio_venta++;
  _rl = _op.and(_t_Precio_venta.poco_barato.isEqual(Precio_venta),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Precio_venta.set(_i_Valoracion_Precio_venta,_rl, _t_Valoracion_Precio_venta.mala); _i_Valoracion_Precio_venta++;
  _rl = _op.and(_t_Precio_venta.poco_barato.isEqual(Precio_venta),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Precio_venta.set(_i_Valoracion_Precio_venta,_rl, _t_Valoracion_Precio_venta.mala); _i_Valoracion_Precio_venta++;
  _rl = _op.and(_t_Precio_venta.poco_barato.isEqual(Precio_venta),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Precio_venta.set(_i_Valoracion_Precio_venta,_rl, _t_Valoracion_Precio_venta.mala); _i_Valoracion_Precio_venta++;
  _rl = _op.and(_t_Precio_venta.normal.isEqual(Precio_venta),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Precio_venta.set(_i_Valoracion_Precio_venta,_rl, _t_Valoracion_Precio_venta.regular); _i_Valoracion_Precio_venta++;
  _rl = _op.and(_t_Precio_venta.normal.isEqual(Precio_venta),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Precio_venta.set(_i_Valoracion_Precio_venta,_rl, _t_Valoracion_Precio_venta.regular); _i_Valoracion_Precio_venta++;
  _rl = _op.and(_t_Precio_venta.normal.isEqual(Precio_venta),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Precio_venta.set(_i_Valoracion_Precio_venta,_rl, _t_Valoracion_Precio_venta.regular); _i_Valoracion_Precio_venta++;
  _rl = _op.and(_t_Precio_venta.normal.isEqual(Precio_venta),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Precio_venta.set(_i_Valoracion_Precio_venta,_rl, _t_Valoracion_Precio_venta.regular); _i_Valoracion_Precio_venta++;
  _rl = _op.and(_t_Precio_venta.caro.isEqual(Precio_venta),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Precio_venta.set(_i_Valoracion_Precio_venta,_rl, _t_Valoracion_Precio_venta.buena); _i_Valoracion_Precio_venta++;
  _rl = _op.and(_t_Precio_venta.caro.isEqual(Precio_venta),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Precio_venta.set(_i_Valoracion_Precio_venta,_rl, _t_Valoracion_Precio_venta.regular); _i_Valoracion_Precio_venta++;
  _rl = _op.and(_t_Precio_venta.caro.isEqual(Precio_venta),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Precio_venta.set(_i_Valoracion_Precio_venta,_rl, _t_Valoracion_Precio_venta.regular); _i_Valoracion_Precio_venta++;
  _rl = _op.and(_t_Precio_venta.caro.isEqual(Precio_venta),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Precio_venta.set(_i_Valoracion_Precio_venta,_rl, _t_Valoracion_Precio_venta.mala); _i_Valoracion_Precio_venta++;
  _rl = _op.and(_t_Precio_venta.muy_caro.isEqual(Precio_venta),_t_Perfil.Pareja_joven_sin_hijos.isEqual(Perfil));
  Valoracion_Precio_venta.set(_i_Valoracion_Precio_venta,_rl, _t_Valoracion_Precio_venta.buena); _i_Valoracion_Precio_venta++;
  _rl = _op.and(_t_Precio_venta.muy_caro.isEqual(Precio_venta),_t_Perfil.Matrimonio_2_3_hijos.isEqual(Perfil));
  Valoracion_Precio_venta.set(_i_Valoracion_Precio_venta,_rl, _t_Valoracion_Precio_venta.buena); _i_Valoracion_Precio_venta++;
  _rl = _op.and(_t_Precio_venta.muy_caro.isEqual(Precio_venta),_t_Perfil.Hombre_soltero.isEqual(Perfil));
  Valoracion_Precio_venta.set(_i_Valoracion_Precio_venta,_rl, _t_Valoracion_Precio_venta.buena); _i_Valoracion_Precio_venta++;
  _rl = _op.and(_t_Precio_venta.muy_caro.isEqual(Precio_venta),_t_Perfil.Mujer_soltera.isEqual(Perfil));
  Valoracion_Precio_venta.set(_i_Valoracion_Precio_venta,_rl, _t_Valoracion_Precio_venta.buena); _i_Valoracion_Precio_venta++;
  MembershipFunction[] _output = new MembershipFunction[1];
  _output[0] = Valoracion_Precio_venta;
  return _output;
 }

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//
 //               Fuzzy Inference Engine                //
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++//

 public double[] crispInference(double[] _input) {
  MembershipFunction Tipo_inmueble = new FuzzySingleton(_input[0]);
  MembershipFunction Luminosidad = new FuzzySingleton(_input[1]);
  MembershipFunction Orientacion = new FuzzySingleton(_input[2]);
  MembershipFunction Representatividad = new FuzzySingleton(_input[3]);
  MembershipFunction Estado_del_portal = new FuzzySingleton(_input[4]);
  MembershipFunction Fachada = new FuzzySingleton(_input[5]);
  MembershipFunction Vistas = new FuzzySingleton(_input[6]);
  MembershipFunction Numero_habitaciones = new FuzzySingleton(_input[7]);
  MembershipFunction Numero_banos = new FuzzySingleton(_input[8]);
  MembershipFunction Antiguedad = new FuzzySingleton(_input[9]);
  MembershipFunction Altura = new FuzzySingleton(_input[10]);
  MembershipFunction Ascensor = new FuzzySingleton(_input[11]);
  MembershipFunction Garaje = new FuzzySingleton(_input[12]);
  MembershipFunction Estado_general = new FuzzySingleton(_input[13]);
  MembershipFunction Zonas_comunes = new FuzzySingleton(_input[14]);
  MembershipFunction Zona_subzona = new FuzzySingleton(_input[15]);
  MembershipFunction Metros_construidos = new FuzzySingleton(_input[16]);
  MembershipFunction Metros_habitables = new FuzzySingleton(_input[17]);
  MembershipFunction Precio_tasacion = new FuzzySingleton(_input[18]);
  MembershipFunction Precio_salida = new FuzzySingleton(_input[19]);
  MembershipFunction Precio_venta = new FuzzySingleton(_input[20]);
  MembershipFunction Perfil = new FuzzySingleton(_input[21]);
  MembershipFunction Valoracion_Tipo_inmueble;
  MembershipFunction Valoracion_Luminosidad;
  MembershipFunction Valoracion_Orientacion;
  MembershipFunction Valoracion_Representatividad;
  MembershipFunction Valoracion_Estado_del_portal;
  MembershipFunction Valoracion_Fachada;
  MembershipFunction Valoracion_Vistas;
  MembershipFunction Valoracion_Numero_habitaciones;
  MembershipFunction Valoracion_Numero_banos;
  MembershipFunction Valoracion_Antiguedad;
  MembershipFunction Valoracion_Altura;
  MembershipFunction Valoracion_Ascensor;
  MembershipFunction Valoracion_Garaje;
  MembershipFunction Valoracion_Estado_general;
  MembershipFunction Valoracion_Zonas_comunes;
  MembershipFunction Valoracion_Zona_subzona;
  MembershipFunction Valoracion_Metros_construidos;
  MembershipFunction Valoracion_Metros_habitables;
  MembershipFunction Valoracion_Precio_tasacion;
  MembershipFunction Valoracion_Precio_salida;
  MembershipFunction Valoracion_Precio_venta;
  MembershipFunction[] _call;
  _call = RL_Inferencia_Tipo_inmueble(Tipo_inmueble,Perfil); Valoracion_Tipo_inmueble=_call[0];
  _call = RL_Inferencia_Luminosidad(Luminosidad,Perfil); Valoracion_Luminosidad=_call[0];
  _call = RL_Inferencia_Orientacion(Orientacion,Perfil); Valoracion_Orientacion=_call[0];
  _call = RL_Inferencia_Representatividad(Representatividad,Perfil); Valoracion_Representatividad=_call[0];
  _call = RL_Inferencia_Estado_del_portal(Estado_del_portal,Perfil); Valoracion_Estado_del_portal=_call[0];
  _call = RL_Inferencia_Fachada(Fachada,Perfil); Valoracion_Fachada=_call[0];
  _call = RL_Inferencia_Vistas(Vistas,Perfil); Valoracion_Vistas=_call[0];
  _call = RL_Inferencia_Numero_habitaciones(Numero_habitaciones,Perfil); Valoracion_Numero_habitaciones=_call[0];
  _call = RL_Inferencia_Numero_banos(Numero_banos,Perfil); Valoracion_Numero_banos=_call[0];
  _call = RL_Inferencia_Antiguedad(Antiguedad,Perfil); Valoracion_Antiguedad=_call[0];
  _call = RL_Inferencia_Altura(Altura,Perfil); Valoracion_Altura=_call[0];
  _call = RL_Inferencia_Ascensor(Ascensor,Perfil); Valoracion_Ascensor=_call[0];
  _call = RL_Inferencia_Garaje(Garaje,Perfil); Valoracion_Garaje=_call[0];
  _call = RL_Inferencia_Estado_general(Estado_general,Perfil); Valoracion_Estado_general=_call[0];
  _call = RL_Inferencia_Zonas_comunes(Zonas_comunes,Perfil); Valoracion_Zonas_comunes=_call[0];
  _call = RL_Inferencia_Zona_subzona(Zona_subzona,Perfil); Valoracion_Zona_subzona=_call[0];
  _call = RL_Inferencia_Metros_construidos(Metros_construidos,Perfil); Valoracion_Metros_construidos=_call[0];
  _call = RL_Inferencia_Metros_habitables(Metros_habitables,Perfil); Valoracion_Metros_habitables=_call[0];
  _call = RL_Inferencia_Precio_tasacion(Precio_tasacion,Perfil); Valoracion_Precio_tasacion=_call[0];
  _call = RL_Inferencia_Precio_salida(Precio_salida,Perfil); Valoracion_Precio_salida=_call[0];
  _call = RL_Inferencia_Precio_venta(Precio_venta,Perfil); Valoracion_Precio_venta=_call[0];
  double _output[] = new double[21];
  if(Valoracion_Tipo_inmueble instanceof FuzzySingleton)
   _output[0] = ((FuzzySingleton) Valoracion_Tipo_inmueble).getValue();
  else _output[0] = ((OutputMembershipFunction) Valoracion_Tipo_inmueble).defuzzify();
  if(Valoracion_Luminosidad instanceof FuzzySingleton)
   _output[1] = ((FuzzySingleton) Valoracion_Luminosidad).getValue();
  else _output[1] = ((OutputMembershipFunction) Valoracion_Luminosidad).defuzzify();
  if(Valoracion_Orientacion instanceof FuzzySingleton)
   _output[2] = ((FuzzySingleton) Valoracion_Orientacion).getValue();
  else _output[2] = ((OutputMembershipFunction) Valoracion_Orientacion).defuzzify();
  if(Valoracion_Representatividad instanceof FuzzySingleton)
   _output[3] = ((FuzzySingleton) Valoracion_Representatividad).getValue();
  else _output[3] = ((OutputMembershipFunction) Valoracion_Representatividad).defuzzify();
  if(Valoracion_Estado_del_portal instanceof FuzzySingleton)
   _output[4] = ((FuzzySingleton) Valoracion_Estado_del_portal).getValue();
  else _output[4] = ((OutputMembershipFunction) Valoracion_Estado_del_portal).defuzzify();
  if(Valoracion_Fachada instanceof FuzzySingleton)
   _output[5] = ((FuzzySingleton) Valoracion_Fachada).getValue();
  else _output[5] = ((OutputMembershipFunction) Valoracion_Fachada).defuzzify();
  if(Valoracion_Vistas instanceof FuzzySingleton)
   _output[6] = ((FuzzySingleton) Valoracion_Vistas).getValue();
  else _output[6] = ((OutputMembershipFunction) Valoracion_Vistas).defuzzify();
  if(Valoracion_Numero_habitaciones instanceof FuzzySingleton)
   _output[7] = ((FuzzySingleton) Valoracion_Numero_habitaciones).getValue();
  else _output[7] = ((OutputMembershipFunction) Valoracion_Numero_habitaciones).defuzzify();
  if(Valoracion_Numero_banos instanceof FuzzySingleton)
   _output[8] = ((FuzzySingleton) Valoracion_Numero_banos).getValue();
  else _output[8] = ((OutputMembershipFunction) Valoracion_Numero_banos).defuzzify();
  if(Valoracion_Antiguedad instanceof FuzzySingleton)
   _output[9] = ((FuzzySingleton) Valoracion_Antiguedad).getValue();
  else _output[9] = ((OutputMembershipFunction) Valoracion_Antiguedad).defuzzify();
  if(Valoracion_Altura instanceof FuzzySingleton)
   _output[10] = ((FuzzySingleton) Valoracion_Altura).getValue();
  else _output[10] = ((OutputMembershipFunction) Valoracion_Altura).defuzzify();
  if(Valoracion_Ascensor instanceof FuzzySingleton)
   _output[11] = ((FuzzySingleton) Valoracion_Ascensor).getValue();
  else _output[11] = ((OutputMembershipFunction) Valoracion_Ascensor).defuzzify();
  if(Valoracion_Garaje instanceof FuzzySingleton)
   _output[12] = ((FuzzySingleton) Valoracion_Garaje).getValue();
  else _output[12] = ((OutputMembershipFunction) Valoracion_Garaje).defuzzify();
  if(Valoracion_Estado_general instanceof FuzzySingleton)
   _output[13] = ((FuzzySingleton) Valoracion_Estado_general).getValue();
  else _output[13] = ((OutputMembershipFunction) Valoracion_Estado_general).defuzzify();
  if(Valoracion_Zonas_comunes instanceof FuzzySingleton)
   _output[14] = ((FuzzySingleton) Valoracion_Zonas_comunes).getValue();
  else _output[14] = ((OutputMembershipFunction) Valoracion_Zonas_comunes).defuzzify();
  if(Valoracion_Zona_subzona instanceof FuzzySingleton)
   _output[15] = ((FuzzySingleton) Valoracion_Zona_subzona).getValue();
  else _output[15] = ((OutputMembershipFunction) Valoracion_Zona_subzona).defuzzify();
  if(Valoracion_Metros_construidos instanceof FuzzySingleton)
   _output[16] = ((FuzzySingleton) Valoracion_Metros_construidos).getValue();
  else _output[16] = ((OutputMembershipFunction) Valoracion_Metros_construidos).defuzzify();
  if(Valoracion_Metros_habitables instanceof FuzzySingleton)
   _output[17] = ((FuzzySingleton) Valoracion_Metros_habitables).getValue();
  else _output[17] = ((OutputMembershipFunction) Valoracion_Metros_habitables).defuzzify();
  if(Valoracion_Precio_tasacion instanceof FuzzySingleton)
   _output[18] = ((FuzzySingleton) Valoracion_Precio_tasacion).getValue();
  else _output[18] = ((OutputMembershipFunction) Valoracion_Precio_tasacion).defuzzify();
  if(Valoracion_Precio_salida instanceof FuzzySingleton)
   _output[19] = ((FuzzySingleton) Valoracion_Precio_salida).getValue();
  else _output[19] = ((OutputMembershipFunction) Valoracion_Precio_salida).defuzzify();
  if(Valoracion_Precio_venta instanceof FuzzySingleton)
   _output[20] = ((FuzzySingleton) Valoracion_Precio_venta).getValue();
  else _output[20] = ((OutputMembershipFunction) Valoracion_Precio_venta).defuzzify();
  return _output;
 }

 public double[] crispInference(MembershipFunction[] _input) {
  MembershipFunction Tipo_inmueble = _input[0];
  MembershipFunction Luminosidad = _input[1];
  MembershipFunction Orientacion = _input[2];
  MembershipFunction Representatividad = _input[3];
  MembershipFunction Estado_del_portal = _input[4];
  MembershipFunction Fachada = _input[5];
  MembershipFunction Vistas = _input[6];
  MembershipFunction Numero_habitaciones = _input[7];
  MembershipFunction Numero_banos = _input[8];
  MembershipFunction Antiguedad = _input[9];
  MembershipFunction Altura = _input[10];
  MembershipFunction Ascensor = _input[11];
  MembershipFunction Garaje = _input[12];
  MembershipFunction Estado_general = _input[13];
  MembershipFunction Zonas_comunes = _input[14];
  MembershipFunction Zona_subzona = _input[15];
  MembershipFunction Metros_construidos = _input[16];
  MembershipFunction Metros_habitables = _input[17];
  MembershipFunction Precio_tasacion = _input[18];
  MembershipFunction Precio_salida = _input[19];
  MembershipFunction Precio_venta = _input[20];
  MembershipFunction Perfil = _input[21];
  MembershipFunction Valoracion_Tipo_inmueble;
  MembershipFunction Valoracion_Luminosidad;
  MembershipFunction Valoracion_Orientacion;
  MembershipFunction Valoracion_Representatividad;
  MembershipFunction Valoracion_Estado_del_portal;
  MembershipFunction Valoracion_Fachada;
  MembershipFunction Valoracion_Vistas;
  MembershipFunction Valoracion_Numero_habitaciones;
  MembershipFunction Valoracion_Numero_banos;
  MembershipFunction Valoracion_Antiguedad;
  MembershipFunction Valoracion_Altura;
  MembershipFunction Valoracion_Ascensor;
  MembershipFunction Valoracion_Garaje;
  MembershipFunction Valoracion_Estado_general;
  MembershipFunction Valoracion_Zonas_comunes;
  MembershipFunction Valoracion_Zona_subzona;
  MembershipFunction Valoracion_Metros_construidos;
  MembershipFunction Valoracion_Metros_habitables;
  MembershipFunction Valoracion_Precio_tasacion;
  MembershipFunction Valoracion_Precio_salida;
  MembershipFunction Valoracion_Precio_venta;
  MembershipFunction[] _call;
  _call = RL_Inferencia_Tipo_inmueble(Tipo_inmueble,Perfil); Valoracion_Tipo_inmueble=_call[0];
  _call = RL_Inferencia_Luminosidad(Luminosidad,Perfil); Valoracion_Luminosidad=_call[0];
  _call = RL_Inferencia_Orientacion(Orientacion,Perfil); Valoracion_Orientacion=_call[0];
  _call = RL_Inferencia_Representatividad(Representatividad,Perfil); Valoracion_Representatividad=_call[0];
  _call = RL_Inferencia_Estado_del_portal(Estado_del_portal,Perfil); Valoracion_Estado_del_portal=_call[0];
  _call = RL_Inferencia_Fachada(Fachada,Perfil); Valoracion_Fachada=_call[0];
  _call = RL_Inferencia_Vistas(Vistas,Perfil); Valoracion_Vistas=_call[0];
  _call = RL_Inferencia_Numero_habitaciones(Numero_habitaciones,Perfil); Valoracion_Numero_habitaciones=_call[0];
  _call = RL_Inferencia_Numero_banos(Numero_banos,Perfil); Valoracion_Numero_banos=_call[0];
  _call = RL_Inferencia_Antiguedad(Antiguedad,Perfil); Valoracion_Antiguedad=_call[0];
  _call = RL_Inferencia_Altura(Altura,Perfil); Valoracion_Altura=_call[0];
  _call = RL_Inferencia_Ascensor(Ascensor,Perfil); Valoracion_Ascensor=_call[0];
  _call = RL_Inferencia_Garaje(Garaje,Perfil); Valoracion_Garaje=_call[0];
  _call = RL_Inferencia_Estado_general(Estado_general,Perfil); Valoracion_Estado_general=_call[0];
  _call = RL_Inferencia_Zonas_comunes(Zonas_comunes,Perfil); Valoracion_Zonas_comunes=_call[0];
  _call = RL_Inferencia_Zona_subzona(Zona_subzona,Perfil); Valoracion_Zona_subzona=_call[0];
  _call = RL_Inferencia_Metros_construidos(Metros_construidos,Perfil); Valoracion_Metros_construidos=_call[0];
  _call = RL_Inferencia_Metros_habitables(Metros_habitables,Perfil); Valoracion_Metros_habitables=_call[0];
  _call = RL_Inferencia_Precio_tasacion(Precio_tasacion,Perfil); Valoracion_Precio_tasacion=_call[0];
  _call = RL_Inferencia_Precio_salida(Precio_salida,Perfil); Valoracion_Precio_salida=_call[0];
  _call = RL_Inferencia_Precio_venta(Precio_venta,Perfil); Valoracion_Precio_venta=_call[0];
  double _output[] = new double[21];
  if(Valoracion_Tipo_inmueble instanceof FuzzySingleton)
   _output[0] = ((FuzzySingleton) Valoracion_Tipo_inmueble).getValue();
  else _output[0] = ((OutputMembershipFunction) Valoracion_Tipo_inmueble).defuzzify();
  if(Valoracion_Luminosidad instanceof FuzzySingleton)
   _output[1] = ((FuzzySingleton) Valoracion_Luminosidad).getValue();
  else _output[1] = ((OutputMembershipFunction) Valoracion_Luminosidad).defuzzify();
  if(Valoracion_Orientacion instanceof FuzzySingleton)
   _output[2] = ((FuzzySingleton) Valoracion_Orientacion).getValue();
  else _output[2] = ((OutputMembershipFunction) Valoracion_Orientacion).defuzzify();
  if(Valoracion_Representatividad instanceof FuzzySingleton)
   _output[3] = ((FuzzySingleton) Valoracion_Representatividad).getValue();
  else _output[3] = ((OutputMembershipFunction) Valoracion_Representatividad).defuzzify();
  if(Valoracion_Estado_del_portal instanceof FuzzySingleton)
   _output[4] = ((FuzzySingleton) Valoracion_Estado_del_portal).getValue();
  else _output[4] = ((OutputMembershipFunction) Valoracion_Estado_del_portal).defuzzify();
  if(Valoracion_Fachada instanceof FuzzySingleton)
   _output[5] = ((FuzzySingleton) Valoracion_Fachada).getValue();
  else _output[5] = ((OutputMembershipFunction) Valoracion_Fachada).defuzzify();
  if(Valoracion_Vistas instanceof FuzzySingleton)
   _output[6] = ((FuzzySingleton) Valoracion_Vistas).getValue();
  else _output[6] = ((OutputMembershipFunction) Valoracion_Vistas).defuzzify();
  if(Valoracion_Numero_habitaciones instanceof FuzzySingleton)
   _output[7] = ((FuzzySingleton) Valoracion_Numero_habitaciones).getValue();
  else _output[7] = ((OutputMembershipFunction) Valoracion_Numero_habitaciones).defuzzify();
  if(Valoracion_Numero_banos instanceof FuzzySingleton)
   _output[8] = ((FuzzySingleton) Valoracion_Numero_banos).getValue();
  else _output[8] = ((OutputMembershipFunction) Valoracion_Numero_banos).defuzzify();
  if(Valoracion_Antiguedad instanceof FuzzySingleton)
   _output[9] = ((FuzzySingleton) Valoracion_Antiguedad).getValue();
  else _output[9] = ((OutputMembershipFunction) Valoracion_Antiguedad).defuzzify();
  if(Valoracion_Altura instanceof FuzzySingleton)
   _output[10] = ((FuzzySingleton) Valoracion_Altura).getValue();
  else _output[10] = ((OutputMembershipFunction) Valoracion_Altura).defuzzify();
  if(Valoracion_Ascensor instanceof FuzzySingleton)
   _output[11] = ((FuzzySingleton) Valoracion_Ascensor).getValue();
  else _output[11] = ((OutputMembershipFunction) Valoracion_Ascensor).defuzzify();
  if(Valoracion_Garaje instanceof FuzzySingleton)
   _output[12] = ((FuzzySingleton) Valoracion_Garaje).getValue();
  else _output[12] = ((OutputMembershipFunction) Valoracion_Garaje).defuzzify();
  if(Valoracion_Estado_general instanceof FuzzySingleton)
   _output[13] = ((FuzzySingleton) Valoracion_Estado_general).getValue();
  else _output[13] = ((OutputMembershipFunction) Valoracion_Estado_general).defuzzify();
  if(Valoracion_Zonas_comunes instanceof FuzzySingleton)
   _output[14] = ((FuzzySingleton) Valoracion_Zonas_comunes).getValue();
  else _output[14] = ((OutputMembershipFunction) Valoracion_Zonas_comunes).defuzzify();
  if(Valoracion_Zona_subzona instanceof FuzzySingleton)
   _output[15] = ((FuzzySingleton) Valoracion_Zona_subzona).getValue();
  else _output[15] = ((OutputMembershipFunction) Valoracion_Zona_subzona).defuzzify();
  if(Valoracion_Metros_construidos instanceof FuzzySingleton)
   _output[16] = ((FuzzySingleton) Valoracion_Metros_construidos).getValue();
  else _output[16] = ((OutputMembershipFunction) Valoracion_Metros_construidos).defuzzify();
  if(Valoracion_Metros_habitables instanceof FuzzySingleton)
   _output[17] = ((FuzzySingleton) Valoracion_Metros_habitables).getValue();
  else _output[17] = ((OutputMembershipFunction) Valoracion_Metros_habitables).defuzzify();
  if(Valoracion_Precio_tasacion instanceof FuzzySingleton)
   _output[18] = ((FuzzySingleton) Valoracion_Precio_tasacion).getValue();
  else _output[18] = ((OutputMembershipFunction) Valoracion_Precio_tasacion).defuzzify();
  if(Valoracion_Precio_salida instanceof FuzzySingleton)
   _output[19] = ((FuzzySingleton) Valoracion_Precio_salida).getValue();
  else _output[19] = ((OutputMembershipFunction) Valoracion_Precio_salida).defuzzify();
  if(Valoracion_Precio_venta instanceof FuzzySingleton)
   _output[20] = ((FuzzySingleton) Valoracion_Precio_venta).getValue();
  else _output[20] = ((OutputMembershipFunction) Valoracion_Precio_venta).defuzzify();
  return _output;
 }

 public MembershipFunction[] fuzzyInference(double[] _input) {
  MembershipFunction Tipo_inmueble = new FuzzySingleton(_input[0]);
  MembershipFunction Luminosidad = new FuzzySingleton(_input[1]);
  MembershipFunction Orientacion = new FuzzySingleton(_input[2]);
  MembershipFunction Representatividad = new FuzzySingleton(_input[3]);
  MembershipFunction Estado_del_portal = new FuzzySingleton(_input[4]);
  MembershipFunction Fachada = new FuzzySingleton(_input[5]);
  MembershipFunction Vistas = new FuzzySingleton(_input[6]);
  MembershipFunction Numero_habitaciones = new FuzzySingleton(_input[7]);
  MembershipFunction Numero_banos = new FuzzySingleton(_input[8]);
  MembershipFunction Antiguedad = new FuzzySingleton(_input[9]);
  MembershipFunction Altura = new FuzzySingleton(_input[10]);
  MembershipFunction Ascensor = new FuzzySingleton(_input[11]);
  MembershipFunction Garaje = new FuzzySingleton(_input[12]);
  MembershipFunction Estado_general = new FuzzySingleton(_input[13]);
  MembershipFunction Zonas_comunes = new FuzzySingleton(_input[14]);
  MembershipFunction Zona_subzona = new FuzzySingleton(_input[15]);
  MembershipFunction Metros_construidos = new FuzzySingleton(_input[16]);
  MembershipFunction Metros_habitables = new FuzzySingleton(_input[17]);
  MembershipFunction Precio_tasacion = new FuzzySingleton(_input[18]);
  MembershipFunction Precio_salida = new FuzzySingleton(_input[19]);
  MembershipFunction Precio_venta = new FuzzySingleton(_input[20]);
  MembershipFunction Perfil = new FuzzySingleton(_input[21]);
  MembershipFunction Valoracion_Tipo_inmueble;
  MembershipFunction Valoracion_Luminosidad;
  MembershipFunction Valoracion_Orientacion;
  MembershipFunction Valoracion_Representatividad;
  MembershipFunction Valoracion_Estado_del_portal;
  MembershipFunction Valoracion_Fachada;
  MembershipFunction Valoracion_Vistas;
  MembershipFunction Valoracion_Numero_habitaciones;
  MembershipFunction Valoracion_Numero_banos;
  MembershipFunction Valoracion_Antiguedad;
  MembershipFunction Valoracion_Altura;
  MembershipFunction Valoracion_Ascensor;
  MembershipFunction Valoracion_Garaje;
  MembershipFunction Valoracion_Estado_general;
  MembershipFunction Valoracion_Zonas_comunes;
  MembershipFunction Valoracion_Zona_subzona;
  MembershipFunction Valoracion_Metros_construidos;
  MembershipFunction Valoracion_Metros_habitables;
  MembershipFunction Valoracion_Precio_tasacion;
  MembershipFunction Valoracion_Precio_salida;
  MembershipFunction Valoracion_Precio_venta;
  MembershipFunction[] _call;
  _call = RL_Inferencia_Tipo_inmueble(Tipo_inmueble,Perfil); Valoracion_Tipo_inmueble=_call[0];
  _call = RL_Inferencia_Luminosidad(Luminosidad,Perfil); Valoracion_Luminosidad=_call[0];
  _call = RL_Inferencia_Orientacion(Orientacion,Perfil); Valoracion_Orientacion=_call[0];
  _call = RL_Inferencia_Representatividad(Representatividad,Perfil); Valoracion_Representatividad=_call[0];
  _call = RL_Inferencia_Estado_del_portal(Estado_del_portal,Perfil); Valoracion_Estado_del_portal=_call[0];
  _call = RL_Inferencia_Fachada(Fachada,Perfil); Valoracion_Fachada=_call[0];
  _call = RL_Inferencia_Vistas(Vistas,Perfil); Valoracion_Vistas=_call[0];
  _call = RL_Inferencia_Numero_habitaciones(Numero_habitaciones,Perfil); Valoracion_Numero_habitaciones=_call[0];
  _call = RL_Inferencia_Numero_banos(Numero_banos,Perfil); Valoracion_Numero_banos=_call[0];
  _call = RL_Inferencia_Antiguedad(Antiguedad,Perfil); Valoracion_Antiguedad=_call[0];
  _call = RL_Inferencia_Altura(Altura,Perfil); Valoracion_Altura=_call[0];
  _call = RL_Inferencia_Ascensor(Ascensor,Perfil); Valoracion_Ascensor=_call[0];
  _call = RL_Inferencia_Garaje(Garaje,Perfil); Valoracion_Garaje=_call[0];
  _call = RL_Inferencia_Estado_general(Estado_general,Perfil); Valoracion_Estado_general=_call[0];
  _call = RL_Inferencia_Zonas_comunes(Zonas_comunes,Perfil); Valoracion_Zonas_comunes=_call[0];
  _call = RL_Inferencia_Zona_subzona(Zona_subzona,Perfil); Valoracion_Zona_subzona=_call[0];
  _call = RL_Inferencia_Metros_construidos(Metros_construidos,Perfil); Valoracion_Metros_construidos=_call[0];
  _call = RL_Inferencia_Metros_habitables(Metros_habitables,Perfil); Valoracion_Metros_habitables=_call[0];
  _call = RL_Inferencia_Precio_tasacion(Precio_tasacion,Perfil); Valoracion_Precio_tasacion=_call[0];
  _call = RL_Inferencia_Precio_salida(Precio_salida,Perfil); Valoracion_Precio_salida=_call[0];
  _call = RL_Inferencia_Precio_venta(Precio_venta,Perfil); Valoracion_Precio_venta=_call[0];
  MembershipFunction _output[] = new MembershipFunction[21];
  _output[0] = Valoracion_Tipo_inmueble;
  _output[1] = Valoracion_Luminosidad;
  _output[2] = Valoracion_Orientacion;
  _output[3] = Valoracion_Representatividad;
  _output[4] = Valoracion_Estado_del_portal;
  _output[5] = Valoracion_Fachada;
  _output[6] = Valoracion_Vistas;
  _output[7] = Valoracion_Numero_habitaciones;
  _output[8] = Valoracion_Numero_banos;
  _output[9] = Valoracion_Antiguedad;
  _output[10] = Valoracion_Altura;
  _output[11] = Valoracion_Ascensor;
  _output[12] = Valoracion_Garaje;
  _output[13] = Valoracion_Estado_general;
  _output[14] = Valoracion_Zonas_comunes;
  _output[15] = Valoracion_Zona_subzona;
  _output[16] = Valoracion_Metros_construidos;
  _output[17] = Valoracion_Metros_habitables;
  _output[18] = Valoracion_Precio_tasacion;
  _output[19] = Valoracion_Precio_salida;
  _output[20] = Valoracion_Precio_venta;
  return _output;
 }

 public MembershipFunction[] fuzzyInference(MembershipFunction[] _input) {
  MembershipFunction Tipo_inmueble = _input[0];
  MembershipFunction Luminosidad = _input[1];
  MembershipFunction Orientacion = _input[2];
  MembershipFunction Representatividad = _input[3];
  MembershipFunction Estado_del_portal = _input[4];
  MembershipFunction Fachada = _input[5];
  MembershipFunction Vistas = _input[6];
  MembershipFunction Numero_habitaciones = _input[7];
  MembershipFunction Numero_banos = _input[8];
  MembershipFunction Antiguedad = _input[9];
  MembershipFunction Altura = _input[10];
  MembershipFunction Ascensor = _input[11];
  MembershipFunction Garaje = _input[12];
  MembershipFunction Estado_general = _input[13];
  MembershipFunction Zonas_comunes = _input[14];
  MembershipFunction Zona_subzona = _input[15];
  MembershipFunction Metros_construidos = _input[16];
  MembershipFunction Metros_habitables = _input[17];
  MembershipFunction Precio_tasacion = _input[18];
  MembershipFunction Precio_salida = _input[19];
  MembershipFunction Precio_venta = _input[20];
  MembershipFunction Perfil = _input[21];
  MembershipFunction Valoracion_Tipo_inmueble;
  MembershipFunction Valoracion_Luminosidad;
  MembershipFunction Valoracion_Orientacion;
  MembershipFunction Valoracion_Representatividad;
  MembershipFunction Valoracion_Estado_del_portal;
  MembershipFunction Valoracion_Fachada;
  MembershipFunction Valoracion_Vistas;
  MembershipFunction Valoracion_Numero_habitaciones;
  MembershipFunction Valoracion_Numero_banos;
  MembershipFunction Valoracion_Antiguedad;
  MembershipFunction Valoracion_Altura;
  MembershipFunction Valoracion_Ascensor;
  MembershipFunction Valoracion_Garaje;
  MembershipFunction Valoracion_Estado_general;
  MembershipFunction Valoracion_Zonas_comunes;
  MembershipFunction Valoracion_Zona_subzona;
  MembershipFunction Valoracion_Metros_construidos;
  MembershipFunction Valoracion_Metros_habitables;
  MembershipFunction Valoracion_Precio_tasacion;
  MembershipFunction Valoracion_Precio_salida;
  MembershipFunction Valoracion_Precio_venta;
  MembershipFunction[] _call;
  _call = RL_Inferencia_Tipo_inmueble(Tipo_inmueble,Perfil); Valoracion_Tipo_inmueble=_call[0];
  _call = RL_Inferencia_Luminosidad(Luminosidad,Perfil); Valoracion_Luminosidad=_call[0];
  _call = RL_Inferencia_Orientacion(Orientacion,Perfil); Valoracion_Orientacion=_call[0];
  _call = RL_Inferencia_Representatividad(Representatividad,Perfil); Valoracion_Representatividad=_call[0];
  _call = RL_Inferencia_Estado_del_portal(Estado_del_portal,Perfil); Valoracion_Estado_del_portal=_call[0];
  _call = RL_Inferencia_Fachada(Fachada,Perfil); Valoracion_Fachada=_call[0];
  _call = RL_Inferencia_Vistas(Vistas,Perfil); Valoracion_Vistas=_call[0];
  _call = RL_Inferencia_Numero_habitaciones(Numero_habitaciones,Perfil); Valoracion_Numero_habitaciones=_call[0];
  _call = RL_Inferencia_Numero_banos(Numero_banos,Perfil); Valoracion_Numero_banos=_call[0];
  _call = RL_Inferencia_Antiguedad(Antiguedad,Perfil); Valoracion_Antiguedad=_call[0];
  _call = RL_Inferencia_Altura(Altura,Perfil); Valoracion_Altura=_call[0];
  _call = RL_Inferencia_Ascensor(Ascensor,Perfil); Valoracion_Ascensor=_call[0];
  _call = RL_Inferencia_Garaje(Garaje,Perfil); Valoracion_Garaje=_call[0];
  _call = RL_Inferencia_Estado_general(Estado_general,Perfil); Valoracion_Estado_general=_call[0];
  _call = RL_Inferencia_Zonas_comunes(Zonas_comunes,Perfil); Valoracion_Zonas_comunes=_call[0];
  _call = RL_Inferencia_Zona_subzona(Zona_subzona,Perfil); Valoracion_Zona_subzona=_call[0];
  _call = RL_Inferencia_Metros_construidos(Metros_construidos,Perfil); Valoracion_Metros_construidos=_call[0];
  _call = RL_Inferencia_Metros_habitables(Metros_habitables,Perfil); Valoracion_Metros_habitables=_call[0];
  _call = RL_Inferencia_Precio_tasacion(Precio_tasacion,Perfil); Valoracion_Precio_tasacion=_call[0];
  _call = RL_Inferencia_Precio_salida(Precio_salida,Perfil); Valoracion_Precio_salida=_call[0];
  _call = RL_Inferencia_Precio_venta(Precio_venta,Perfil); Valoracion_Precio_venta=_call[0];
  MembershipFunction _output[] = new MembershipFunction[21];
  _output[0] = Valoracion_Tipo_inmueble;
  _output[1] = Valoracion_Luminosidad;
  _output[2] = Valoracion_Orientacion;
  _output[3] = Valoracion_Representatividad;
  _output[4] = Valoracion_Estado_del_portal;
  _output[5] = Valoracion_Fachada;
  _output[6] = Valoracion_Vistas;
  _output[7] = Valoracion_Numero_habitaciones;
  _output[8] = Valoracion_Numero_banos;
  _output[9] = Valoracion_Antiguedad;
  _output[10] = Valoracion_Altura;
  _output[11] = Valoracion_Ascensor;
  _output[12] = Valoracion_Garaje;
  _output[13] = Valoracion_Estado_general;
  _output[14] = Valoracion_Zonas_comunes;
  _output[15] = Valoracion_Zona_subzona;
  _output[16] = Valoracion_Metros_construidos;
  _output[17] = Valoracion_Metros_habitables;
  _output[18] = Valoracion_Precio_tasacion;
  _output[19] = Valoracion_Precio_salida;
  _output[20] = Valoracion_Precio_venta;
  return _output;
 }

}
